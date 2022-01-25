package com.master.application.model;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.master.application.entity.ApplicationRanking;

public class ApplicationRankingModel {
  private Long id;
  private Long application_id;
  private ArrayList<Long> professors_id = new ArrayList<>();
  private int rank;

  public ApplicationRankingModel() {
	    
  }
  
  public ApplicationRankingModel(ApplicationRanking applicationRanking) {
    this.id = applicationRanking.getId();
    this.application_id = applicationRanking.getApplication().getId();
    this.rank=applicationRanking.getRank();
    getProfessors_id().add(applicationRanking.getTeacher().getId());
  }
  
  public Long getApplication_id() {
    return application_id;
  }

  public void setApplication_id(Long application_id) {
    this.application_id = application_id;
  }

  public int getRank() {
    return rank;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  public void showRank() {
  }

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public ArrayList<Long> getProfessors_id() {
	return professors_id;
}

public void setProfessors_id(ArrayList<Long> professors_id) {
	this.professors_id = professors_id;
}

}
