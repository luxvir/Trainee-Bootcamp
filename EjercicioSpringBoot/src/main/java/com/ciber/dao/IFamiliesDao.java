package com.ciber.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciber.model.Families;

@Repository
public interface IFamiliesDao extends JpaRepository<Families, Integer> {

}
