package com.ciber.service;

import com.ciber.dao.IFamiliesDao;
import com.ciber.dao.IFamilyMembersDao;
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

  @Override
  public List<Families> findAll() {
    return dao.findAll();
  }

  @Override
  public Families create(Families fami) {
    return dao.save(fami);
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
    return (List<FamilyMembers>)daoMem.findByFamiliesFamilyId(famiId); 
  }

}
