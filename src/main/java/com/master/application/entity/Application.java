package com.master.application.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "application")
public class Application {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, unique = true)
  private Long id;
  
  @Column(name = "thesis_degree", nullable = false, unique = true)
  private BigDecimal thesisDegree;
  
  @Column(name = "bachelor_title", nullable = false, unique = true)
  private String bachelorTitle;
  
  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "referral1_id", nullable = false)
  private Referral referral1;
  
  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "referral2_id", nullable = false)
  private Referral referral2;
  
  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "student_id", nullable = false)
  private User student;
  
  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "master_id", nullable = false)
  private Master master;

  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * @return the thesisDegree
   */
  public BigDecimal getThesisDegree() {
    return thesisDegree;
  }

  /**
   * @param thesisDegree the thesisDegree to set
   */
  public void setThesisDegree(BigDecimal thesisDegree) {
    this.thesisDegree = thesisDegree;
  }

  /**
   * @return the bachelorTitle
   */
  public String getBachelorTitle() {
    return bachelorTitle;
  }

  /**
   * @param bachelorTitle the bachelorTitle to set
   */
  public void setBachelorTitle(String bachelorTitle) {
    this.bachelorTitle = bachelorTitle;
  }

  /**
   * @return the referral1
   */
  public Referral getReferral1() {
    return referral1;
  }

  /**
   * @param referral1 the referral1 to set
   */
  public void setReferral1(Referral referral1) {
    this.referral1 = referral1;
  }

  /**
   * @return the referral2
   */
  public Referral getReferral2() {
    return referral2;
  }

  /**
   * @param referral2 the referral2 to set
   */
  public void setReferral2(Referral referral2) {
    this.referral2 = referral2;
  }

  /**
   * @return the student
   */
  public User getStudent() {
    return student;
  }

  /**
   * @param student the student to set
   */
  public void setStudent(User student) {
    this.student = student;
  }

  /**
   * @return the master
   */
  public Master getMaster() {
    return master;
  }

  /**
   * @param master the master to set
   */
  public void setMaster(Master master) {
    this.master = master;
  }

  @Override
  public String toString() {
    return "Application [id=" + id + ", thesisDegree=" + thesisDegree + ", bachelorTitle="
        + bachelorTitle + ", referral1=" + referral1 + ", referral2=" + referral2 + ", student="
        + student + ", master=" + master + "]";
  }
}
