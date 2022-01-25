package com.master.application.model;


import com.master.application.entity.Referral;

public class ReferralModel {
  private Long id;
  private Long professor_id;
  private Long student_id;
  private String text;

  public ReferralModel() {
	    
  }
  
  public ReferralModel(Referral referral) {
    this.id = referral.getId();
    this.professor_id = referral.getTeacher().getId();
    this.student_id = referral.getStudent().getId();
    this.text = referral.getText();
  }
  
  public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Long getStudent_id() {
    return student_id;
  }

  public void setStudent_id(Long student_id) {
    this.student_id = student_id;
  }

  public Long getProfessor_id() {
    return professor_id;
  }

  public void setProfessor_id(Long professor_id) {
    this.professor_id = professor_id;
  }

  
}
