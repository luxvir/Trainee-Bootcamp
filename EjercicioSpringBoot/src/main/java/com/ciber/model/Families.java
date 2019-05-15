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

/**
 * The class Families is a model that defines a set of variables -the state, and
 * appropriate methods to operate with said data -the behavior.
 * @version 15/05/2019 V.1
 * @author vperezqu.
 *
 */
@Data
@Entity
public class Families {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "family_id")
  private int familyId;

  @Column(name = "family_name", length = 50, nullable = false)
  private String familyName;

  @ManyToOne
  @JoinColumn(name = "head_of_family_parent_id", nullable = false)
  private Parents parents;

  @JsonIgnore
  @OneToMany(mappedBy = "families")
  private List<FamilyMembers> familyMembers;

}
