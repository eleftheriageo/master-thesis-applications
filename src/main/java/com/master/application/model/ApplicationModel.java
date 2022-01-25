package com.master.application.model;

import java.math.BigDecimal;

import com.master.application.entity.Application;

public class ApplicationModel {

  private Long id;
  private BigDecimal degree;
  private String thesisTitle;
  private Long referralId1;
  private Long referralId2;
  private Long masterId;
  private Long studentId;
  
  public ApplicationModel() {
    
  }
  
  public ApplicationModel(Application application) {
    this.id = application.getId();
    this.degree = application.getThesisDegree();
    this.thesisTitle = application.getBachelorTitle();
    this.masterId = application.getMaster().getId();
    this.studentId = application.getStudent().getId();
    this.referralId1 = application.getReferral1().getId();
    this.referralId2 = application.getReferral2().getId();
  }

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
   * @return the degree
   */
  public BigDecimal getDegree() {
    return degree;
  }

  /**
   * @param degree
   *          the degree to set
   */
  public void setDegree(BigDecimal degree) {
    this.degree = degree;
  }

  /**
   * @return the thesisTitle
   */
  public String getThesisTitle() {
    return thesisTitle;
  }

  /**
   * @param thesisTitle
   *          the thesisTitle to set
   */
  public void setThesisTitle(String thesisTitle) {
    this.thesisTitle = thesisTitle;
  }

  /**
   * @return the referralId1
   */
  public Long getReferralId1() {
    return referralId1;
  }

  /**
   * @param referralId1
   *          the referralId1 to set
   */
  public void setReferralId1(Long referralId1) {
    this.referralId1 = referralId1;
  }

  /**
   * @return the referralId2
   */
  public Long getReferralId2() {
    return referralId2;
  }

  /**
   * @param referralId2
   *          the referralId2 to set
   */
  public void setReferralId2(Long referralId2) {
    this.referralId2 = referralId2;
  }

  /**
   * @return the masterId
   */
  public Long getMasterId() {
    return masterId;
  }

  /**
   * @param masterId
   *          the masterId to set
   */
  public void setMasterId(Long masterId) {
    this.masterId = masterId;
  }

  /**
   * @return the studentId
   */
  public Long getStudentId() {
    return studentId;
  }

  /**
   * @param studentId
   *          the studentId to set
   */
  public void setStudentId(Long studentId) {
    this.studentId = studentId;
  }
}
