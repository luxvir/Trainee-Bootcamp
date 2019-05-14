package com.ciber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciber.dao.IFamiliesDao;
import com.ciber.model.Families;


@Service
public class FamiliesServiceImpl implements IFamiliesService{

  @Autowired
  private IFamiliesDao dao;

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
  

}
