package com.ciber.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciber.model.Students;

@Repository
public interface IStudentsDao extends JpaRepository<Students, Integer> {

}
