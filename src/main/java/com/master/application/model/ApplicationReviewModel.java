package com.master.application.model;

import com.master.application.entity.ApplicationReview;

public class ApplicationReviewModel {
	private Long id;
  private Long application_id;
  private Long secretary_id;
  private boolean accepted;

  //giati duo constructors?
  public ApplicationReviewModel() {
	    
  }

  public ApplicationReviewModel(ApplicationReview applicationReview) {
    this.id=applicationReview.getId();
    this.application_id=applicationReview.getApplication().getId();
    this.secretary_id = applicationReview.getSecretary().getId();
    this.accepted = applicationReview.isAccepted();

  }
  public boolean isAccepted() {
    return accepted;
  }

  public void setAccepted(boolean accepted) {
    this.accepted = accepted;
  }

  public Long getSecretary_id() {
    return secretary_id;
  }

  public void setSecretary_id(Long secretary_id) {
    this.secretary_id = secretary_id;
  }

  public Long getApplication_id() {
    return application_id;
  }

  public void setApplication_id(Long application_id) {
    this.application_id = application_id;
  }

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

  @Override
  public String toString() {
    return "ApplicationReviewModel{" +
            "id=" + id +
            ", application_id=" + application_id +
            ", secretary_id=" + secretary_id +
            ", accepted=" + accepted +
            '}';
  }
}
