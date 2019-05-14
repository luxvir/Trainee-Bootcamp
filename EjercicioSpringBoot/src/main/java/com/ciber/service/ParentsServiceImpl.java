package com.ciber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciber.dao.IParentsDao;
import com.ciber.model.Parents;

@Service
public class ParentsServiceImpl  implements IParentsService {

  @Autowired
  private IParentsDao dao;
  
  @Override
  public List<Parents> findAll() {
    return dao.findAll();
  }

  @Override
  public Parents create(Parents paren) {
    return dao.save(paren);
  }

  @Override
  public Parents update(Parents paren) {
    return dao.save(paren);
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
