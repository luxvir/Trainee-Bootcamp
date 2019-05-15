package com.ciber.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class FamilyMembers {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int family_member_id;
  
  @Column(name = "parent_or_student_member", length = 100, nullable = true)
  private String parent_or_student_member;
  
  @ManyToOne
  @JoinColumn(name = "family_id", nullable = false)
  private Families families;
  
  @ManyToOne
  @JoinColumn(name = "parent_id", nullable = false)
  private Parents parents;
  
  @ManyToOne
  @JoinColumn(name = "student_id", nullable = false)
  private Students students; 
  
}
