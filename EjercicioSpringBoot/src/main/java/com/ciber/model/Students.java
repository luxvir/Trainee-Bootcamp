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

/**
 * La clase Students es un modelo que define un conjunto de variables el estado, y métodos
 * apropiados para operar con dichos datos.
 * @version 15/05/2019 V.1
 * @author vperezqu.
 *
 */
@Data
@Entity
public class Students {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "student_id")
  private int studentId;

  @Column(name = "first_name", length = 20, nullable = false)
  private String firstName;

  @Column(name = "middle_name", length = 20, nullable = false)
  private String middleName;

  @Column(name = "last_name", length = 20, nullable = false)
  private String lastName;

  @Temporal(TemporalType.DATE)
  @Column(name = "date_of_birth")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota")
  private Date dateOfBirth;

  @Column(name = "other_students_details", length = 100, nullable = false)
  private String otherStudentsDetails;

  @JsonIgnore
  @OneToMany(mappedBy = "students")
  private List<FamilyMembers> familyMembers;

  @JsonIgnore
  @ManyToMany(mappedBy = "students")
  private List<Parents> parents;

}
