package com.ciber.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Families {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int family_id;

  @Column(name = "family_name", length = 50, nullable = false)
  private String family_name;

  @ManyToOne
  @JoinColumn(name = "head_of_family_parent_id", nullable = false)
  private Parents parents;

  @JsonIgnore
  @OneToMany(mappedBy = "families")
  private List<FamilyMembers> familyMembers;

}
