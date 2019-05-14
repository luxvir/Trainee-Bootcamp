package com.ciber.service;

import java.util.List;

import com.ciber.model.Students;

public interface IStudents {

  List<Students> findAll();

  Students create(Students stu);

  Students update(Students stu);

  int delete(Integer id);
}
