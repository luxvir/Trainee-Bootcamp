package com.ciber.service;

import com.ciber.dao.IFamiliesDao;
import com.ciber.dao.IFamilyMembersDao;
import com.ciber.dao.IParentsDao;
import com.ciber.dao.IStudentsDao;
import com.ciber.model.FamilyMembers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyMembersServiceImpl implements IFamilyMembersService {

  @Autowired
  private IFamilyMembersDao dao;

  @Autowired
  private IParentsDao daoParen;

  @Autowired
  private IFamiliesDao daoFami;

  @Autowired
  private IStudentsDao daoStu;

  @Override
  public List<FamilyMembers> findAll() {
    return (List<FamilyMembers>) dao.findAll();
  }


  FamilyMembers faMembers;

  @Override
  public FamilyMembers create(FamilyMembers famiMem) {
    System.out.println("entro");
    try {
      if (famiMem.getParentOrStudentMember().equals("P")) {
        daoParen.findById(famiMem.getParents().getParentId()).ifPresent((p) -> {
          famiMem.setParents(p);
          System.out.println("cod parents " + famiMem.getParents().getParentId());

          daoFami.findById(famiMem.getFamilies().getFamilyId()).ifPresent((q) -> {
            System.out.println("codigo encontrado de fami " + famiMem.getFamilies().getFamilyId());
            famiMem.setFamilies(q);
          });
  
          faMembers = dao.save(famiMem);
        });

      } else if (famiMem.getParentOrStudentMember().equals("S")) {
        daoStu.findById(famiMem.getStudents().getStudentId()).ifPresent((s) -> {
          famiMem.setStudents(s);
          System.out.println("cod studiante " + famiMem.getStudents().getStudentId());

          daoFami.findById(famiMem.getFamilies().getFamilyId()).ifPresent((q) -> {
            System.out.println("codigo encontrado de fam " + famiMem.getFamilies().getFamilyId());
            famiMem.setFamilies(q);
          });
         
          faMembers = dao.save(famiMem);
        });

      }

    } catch (Exception e) {
      System.out.println("Error: " + e);
    }

    System.out.println("salio");
    return dao.save(famiMem);
  }

  @Override
  public FamilyMembers update(FamilyMembers famiMem) {
    return dao.save(famiMem);
  }

  @Override
  public int delete(Integer id) {
    int rpta = 0;
    try {
      dao.deleteById(id);
      rpta = 1;
    } catch (Exception e) {
      rpta = 0;
    }
    return rpta;
  }

}
