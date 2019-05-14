package com.ciber.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Students {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int student_id;
  
  @Column(name = "first_name", length = 20, nullable = false)
  private String first_name;
  
  @Column(name = "middle_name", length = 20, nullable = false)
  private String middle_name;
  
  @Column(name = "last_name", length = 20, nullable = false)
  private String last_name;
  
  // falta date_of_birth;
  @Temporal(TemporalType.DATE)
  @Column(name = "date_of_birth")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota")
  private Date date_of_birth;
  
  @Column(name = "other_students_details", length = 100, nullable = false)
  private String other_students_details;
  
  @JsonIgnore
  @OneToMany(mappedBy = "students")
  private List<FamilyMembers>   familyMembers;
  
  @JsonIgnore
  @ManyToMany(mappedBy = "students")
  private List<Parents> parents;

  public int getStudent_id() {
    return student_id;
  }

  public void setStudent_id(int student_id) {
    this.student_id = student_id;
  }

  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
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

  public Date getDate_of_birth() {
    return date_of_birth;
  }

  public void setDate_of_birth(Date date_of_birth) {
    this.date_of_birth = date_of_birth;
  }

  public String getOther_students_details() {
    return other_students_details;
  }

  public void setOther_students_details(String other_students_details) {
    this.other_students_details = other_students_details;
  }

  public List<FamilyMembers> getFamilyMembers() {
    return familyMembers;
  }

  public void setFamilyMembers(List<FamilyMembers> familyMembers) {
    this.familyMembers = familyMembers;
  }

  public List<Parents> getParents() {
    return parents;
  }

  public void setParents(List<Parents> parents) {
    this.parents = parents;
  }
}
