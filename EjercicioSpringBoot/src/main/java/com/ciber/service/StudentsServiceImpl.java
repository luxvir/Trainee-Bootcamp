package com.ciber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciber.dao.IStudentsDao;
import com.ciber.model.Students;

@Service
public class StudentsServiceImpl implements IStudents {

  @Autowired
  private IStudentsDao dao;
  @Override
  public List<Students> findAll() {
    return dao.findAll();
  }

  @Override
  public Students create(Students stu) {
    return dao.save(stu);
  }

  @Override
  public Students update(Students stu) {
    return dao.save(stu);
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

