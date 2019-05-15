package com.ciber.service;

import com.ciber.dao.IFamilyMembersDao;
import com.ciber.model.FamilyMembers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyMembersImpl implements IFamilyMembersService {

  @Autowired
  IFamilyMembersDao dao;

  @Override
  public List<FamilyMembers> findAll() {
    return (List<FamilyMembers>) dao.findAll();
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
