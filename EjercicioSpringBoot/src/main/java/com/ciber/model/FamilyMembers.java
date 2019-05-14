package com.ciber.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


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

  public int getFamily_member_id() {
    return family_member_id;
  }

  public void setFamily_member_id(int family_member_id) {
    this.family_member_id = family_member_id;
  }

  public String getParent_or_student_member() {
    return parent_or_student_member;
  }

  public void setParent_or_student_member(String parent_or_student_member) {
    this.parent_or_student_member = parent_or_student_member;
  }

  public Families getFamilies() {
    return families;
  }

  public void setFamilies(Families families) {
    this.families = families;
  }

  public Parents getParents() {
    return parents;
  }

  public void setParents(Parents parents) {
    this.parents = parents;
  }

  public Students getStudents() {
    return students;
  }

  public void setStudents(Students students) {
    this.students = students;
  }
  
  
}
