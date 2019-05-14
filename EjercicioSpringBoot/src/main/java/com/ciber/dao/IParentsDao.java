package com.ciber.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciber.model.Parents;

@Repository
public interface IParentsDao extends JpaRepository<Parents, Integer>{

}
