package com.ciber.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

import lombok.Data;

@Data
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

  @Temporal(TemporalType.DATE)
  @Column(name = "date_of_birth")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota")
  private Date date_of_birth;

  @Column(name = "other_students_details", length = 100, nullable = false)
  private String other_students_details;

  @JsonIgnore
  @OneToMany(mappedBy = "students")
  private List<FamilyMembers> familyMembers;

  @JsonIgnore
  @ManyToMany(mappedBy = "students")
  private List<Parents> parents;

}
