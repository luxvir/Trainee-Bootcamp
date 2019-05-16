package com.ciber.service;

import com.ciber.dao.IFamiliesDao;
import com.ciber.dao.IFamilyMembersDao;
import com.ciber.dao.IParentsDao;
import com.ciber.model.Families;
import com.ciber.model.FamilyMembers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class FamiliesServiceImpl implements IFamiliesService {

  @Autowired
  private IFamiliesDao dao;

  @Autowired
  private IFamilyMembersDao daoMem;

  @Autowired
  private IParentsDao daoParen;

  @Override
  public List<Families> findAll() {
    return dao.findAll();
  }

  // lo declaro para almacenarlo y retornalo
  Families famili = new Families();

  @Override
  public Families create(Families fami) {
    System.out.println("entro");
    try {

      // lo busca
      daoParen.findById(fami.getParents().getParentId()).ifPresent((p) -> {
        System.out.println("codigo encontrado" + fami.getParents().getParentId());
        // lo guarda
        fami.setFamilyId(fami.getFamilyId());
        System.out.println("lo encontro");

        // lo registra
        famili = dao.save(fami);
      });

    } catch (Exception e) {
      System.out.println(e);
    }
    System.out.println("registrado");
    return famili;
  }

  @Override
  public Families update(Families fami) {
    return dao.save(fami);
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

  @Override
  public List<FamilyMembers> findByFamilies(int famiId) {
    return (List<FamilyMembers>) daoMem.findByFamiliesFamilyId(famiId);
  }

}
