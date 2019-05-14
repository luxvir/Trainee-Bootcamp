package com.ciber.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Parents {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int parent_id;
  
  @Column(name = "gender", length = 9, nullable = false)
  private String gender;
  
  @Column(name = "fisrst_name", length = 20, nullable = false)
  private String fisrst_name;
  
  @Column(name = "middle_name", length = 20, nullable = false)
  private String middle_name;
  
  @Column(name = "last_name", length = 20, nullable = false)
  private String last_name;
  
  @Column(name = "other_parent_details",length = 100, nullable = false)
  private String other_parent_details;
  
  public int getParent_id() {
    return parent_id;
  }

  public void setParent_id(int parent_id) {
    this.parent_id = parent_id;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getFisrst_name() {
    return fisrst_name;
  }

  public void setFisrst_name(String fisrst_name) {
    this.fisrst_name = fisrst_name;
  }

  public String getMiddle_name() {
    return middle_name;
  }

  public void setMiddle_name(String middle_name) {
    this.middle_name = middle_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public String getOther_parent_details() {
    return other_parent_details;
  }

  public void setOther_parent_details(String other_parent_details) {
    this.other_parent_details = other_parent_details;
  }

  @JsonIgnore
  @JoinTable(
      name="studentParents",
      joinColumns=
          @JoinColumn(name="parent_id", referencedColumnName="parent_id"),
      inverseJoinColumns=
          @JoinColumn(name="student_id", referencedColumnName="student_id")
  )
  @ManyToMany(cascade = CascadeType.ALL)
  private List<Students> students;
  
  @JsonIgnore
  @OneToMany(mappedBy = "parents")
  private List<Families> families;
  
  @JsonIgnore
  @OneToMany(mappedBy = "parents")
      private List<FamilyMembers> familyMembers;
      
  public List<Families> getFamilies() {
    return families;
  }

  public void setFamilies(List<Families> families) {
    this.families = families;
  }

  public List<FamilyMembers> getFamilyMembers() {
    return familyMembers;
  }

  public void setFamilyMembers(List<FamilyMembers> familyMembers) {
    this.familyMembers = familyMembers;
  }

  public List<Students> getStudents() {
    return students;
  }

  public void setStudents(List<Students> students) {
    this.students = students;
  }
}
