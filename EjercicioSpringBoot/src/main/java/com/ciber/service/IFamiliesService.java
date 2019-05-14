package com.ciber.service;

import java.util.List;

import com.ciber.model.Families;


public interface IFamiliesService {
  List<Families> findAll();

  Families create(Families fami);

  Families update(Families fami);

  int delete(Integer id);
}
