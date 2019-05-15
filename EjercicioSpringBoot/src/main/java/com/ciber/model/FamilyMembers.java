package com.ciber.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

/**
 * The class FamilyMembers is a model that defines a set of variables -the
 * state, and appropriate methods to operate with said data -the behavior.
 * @version 15/05/2019 V.1
 * @author vperezqu.
 *
 */
@Data
@Entity
public class FamilyMembers {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "family_member_id")
  private int familyMemberId;

  @Column(name = "parent_or_student_member", length = 100, nullable = true)
  private String parentOrStudentMember;

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
