package com.ciber.service;

import java.util.List;

import com.ciber.model.Parents;

public interface IParentsService {
  List<Parents> findAll();

  Parents create(Parents paren);

  Parents update(Parents paren);

  int delete(Integer id);
}
