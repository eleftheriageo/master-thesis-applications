package com.master.application.entity;

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
@Table(name = "application_review")
public class ApplicationReview {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, unique = true)
  private Long id;
  
  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "application_id", nullable = false, unique = true)
  private Application application;

  @Column(name = "is_accepted", nullable = false, unique = true)
  private boolean isAccepted;

  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "secretary_id", nullable = true)
  private User secretary;

  public void setSecretary(User secretary) {
    this.secretary = secretary;
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
   * @return the application
   */
  public Application getApplication() {
    return application;
  }

  /**
   * @param application the application to set
   */
  public void setApplication(Application application) {
    this.application = application;
  }

  /**
   * @return the isAccepted
   */
  public boolean isAccepted() {
    return isAccepted;
  }

  /**
   * @param isAccepted the isAccepted to set
   */
  public void setAccepted(boolean isAccepted) {
    this.isAccepted = isAccepted;
  }

  /**
   * @return the secretary
   */
  public User getSecretary() {
    return secretary;
  }
//giati??
public Long getApplication_id() {
	// TODO Auto-generated method stub
	return null;
}

public Long getSecretary_id() {
	// TODO Auto-generated method stub
	return null;
}






}
