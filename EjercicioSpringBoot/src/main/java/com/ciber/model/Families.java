package com.ciber.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;



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

  public int getFamily_id() {
    return family_id;
  }

  public void setFamily_id(int family_id) {
    this.family_id = family_id;
  }

  public String getFamily_name() {
    return family_name;
  }

  public void setFamily_name(String family_name) {
    this.family_name = family_name;
  }

  public Parents getParents() {
    return parents;
  }

  public void setParents(Parents parents) {
    this.parents = parents;
  }

  public List<FamilyMembers> getFamilyMembers() {
    return familyMembers;
  }

  public void setFamilyMembers(List<FamilyMembers> familyMembers) {
    this.familyMembers = familyMembers;
  }
  
  
}
