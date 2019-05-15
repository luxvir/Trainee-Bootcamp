package com.ciber.service;

import com.ciber.model.Students;
import java.util.List;

public interface IStudentsService {
  
  List<Students> findAll();

  Students create(Students stu);

  Students update(Students stu);

  int delete(Integer id);
}
