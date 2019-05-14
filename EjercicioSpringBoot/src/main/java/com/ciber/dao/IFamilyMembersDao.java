package com.ciber.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciber.model.FamilyMembers;

@Repository
public interface IFamilyMembersDao extends JpaRepository<FamilyMembers, Integer> {

}
