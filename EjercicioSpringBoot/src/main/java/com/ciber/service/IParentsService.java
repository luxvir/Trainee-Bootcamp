package com.ciber.service;

import com.ciber.model.Parents;

import java.util.List;

public interface IParentsService {
  List<Parents> findAll();

  Parents create(Parents paren);

  Parents update(Parents paren);

  int delete(Integer id);
}
