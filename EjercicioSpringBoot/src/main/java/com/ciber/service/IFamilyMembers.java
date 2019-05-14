package com.ciber.service;

import java.util.List;

import com.ciber.model.FamilyMembers;

public interface IFamilyMembers {

  List<FamilyMembers> findAll();

  FamilyMembers create(FamilyMembers famiMem);

  FamilyMembers update(FamilyMembers famiMem);

  int delete(Integer id);
}
