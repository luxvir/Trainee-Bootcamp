package com.ciber.service;

import com.ciber.model.Families;
import com.ciber.model.FamilyMembers;

import java.util.List;

public interface IFamiliesService {
  List<Families> findAll();

  Families create(Families fami);

  Families update(Families fami);

  int delete(Integer id);

  List<FamilyMembers> findByFamilies(int famiId);
}
