package com.ciber.controller;

import com.ciber.dao.IFamilyMembersDao;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class FamilyMembersControllerTest {
  @Autowired
  private IFamilyMembersDao dao;

  @Test
  public void testListfamilyMembers() {
    dao.findAll();
  }

  @Test
  public void testCreatefamilyMembers() {
    // FamilyMembers f = new FamilyMembers();
  }

  @Test
  public void testUpdatefamilyMembers() {

  }

  @Test
  public void testDeletefamilyMembers() {
    dao.deleteById(1);
  }

}
