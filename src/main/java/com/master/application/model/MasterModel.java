package com.master.application.model;


import java.math.BigDecimal;

import com.master.application.entity.Master;

public class MasterModel {
  private Long id;
  private String name;
  private String proipothesis;



public String getProipothesis() {
	return proipothesis;
}

public void setProipothesis(String proipothesis) {
	this.proipothesis = proipothesis;
}



public MasterModel() {
	    
  }
  
  public MasterModel(Master master) {
    this.id = master.getId();
    this.name = master.getName();
  }

  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  
}
