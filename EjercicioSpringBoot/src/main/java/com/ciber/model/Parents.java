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

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
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

  @Column(name = "other_parent_details", length = 100, nullable = false)
  private String other_parent_details;

  @JsonIgnore
  @JoinTable(name = "studentParents", joinColumns = @JoinColumn(name = "parent_id", referencedColumnName = "parent_id"), inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"))
  @ManyToMany(cascade = CascadeType.ALL)
  private List<Students> students;

  @JsonIgnore
  @OneToMany(mappedBy = "parents")
  private List<Families> families;

  @JsonIgnore
  @OneToMany(mappedBy = "parents")
  private List<FamilyMembers> familyMembers;

}
