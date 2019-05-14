package com.ciber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciber.dao.IFamilyMembersDao;
import com.ciber.model.FamilyMembers;

@Service
public class FamilyMembersImpl  implements IFamilyMembers{

  @Autowired
  IFamilyMembersDao dao;
  @Override
  public List<FamilyMembers> findAll() {
    return dao.findAll();
  }

  @Override
  public FamilyMembers create(FamilyMembers famiMem) {
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
