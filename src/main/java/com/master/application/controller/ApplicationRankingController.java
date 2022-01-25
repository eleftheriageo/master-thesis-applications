package com.master.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.master.application.model.ApplicationRankingModel;
import com.master.application.model.ErrorModel;
import com.master.application.service.ApplicationRankingService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/applicationraking")
public class ApplicationRankingController {
	 @Autowired
	  private ApplicationRankingService applicationRankingService;
	  
	  @GetMapping
	  public List<ApplicationRankingModel> getApplicationRankings() {
	    return applicationRankingService.getApplicationRankings();
	  }
	  
	  @GetMapping("/{id}")
	  public ApplicationRankingModel getApplicationRankingById(@PathVariable Long id) {
	    return applicationRankingService.getApplicationRanking(id);
	  }
	  
	  @PostMapping
	  public List<ApplicationRankingModel> createApplicationRanking(@RequestBody ApplicationRankingModel applicationRankingModel) {
	    return applicationRankingService.createApplicationRanking(applicationRankingModel);
	  }
	  
	  @PutMapping("/{id}")
	  public ApplicationRankingModel editApplicationRanking(@PathVariable Long id, @RequestBody ApplicationRankingModel applicationRankingModel, List<Long> professors_id) {
	    return applicationRankingService.editApplicationRanking(id, applicationRankingModel, professors_id);
	  }
	  
	  @DeleteMapping("/{id}")
	  public ResponseEntity<Void> deleteApplicationRanking(@PathVariable Long id) {
	    applicationRankingService.deleteApplicationRanking(id);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }
	  
	  @ExceptionHandler(IllegalArgumentException.class)
	  public ResponseEntity<ErrorModel> handleException(IllegalArgumentException exception) {
	    ErrorModel errorModel = new ErrorModel();
	    errorModel.setMessage(exception.getMessage());
	    errorModel.setExceptionType(exception.getClass().getCanonicalName());
	    return new ResponseEntity<ErrorModel>(errorModel, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}


