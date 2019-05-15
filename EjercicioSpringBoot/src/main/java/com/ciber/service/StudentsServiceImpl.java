package com.ciber.service;

import com.ciber.dao.IStudentsDao;
import com.ciber.model.Students;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentsServiceImpl implements IStudentsService {

  @Autowired
  private IStudentsDao dao;

  /**
   * The function findAll() returns the list of students.
   * 
   * @return list of students.
   */
  @Override
  public List<Students> findAll() {
    return dao.findAll();
  }

  /**
   * The function create() is responsible for creating a student object.
   * 
   * @return student.
   */
  @Override
  public Students create(Students stu) {
    return dao.save(stu);
  }

  /**
   * The function create() is responsible for creating a student object.
   * 
   * @return student.
   */
  @Override
  public Students update(Students stu) {
    return dao.save(stu);
  }

  /**
   * The function delete() is responsible for delete a student object.
   * 
   * @return student.
   */
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
