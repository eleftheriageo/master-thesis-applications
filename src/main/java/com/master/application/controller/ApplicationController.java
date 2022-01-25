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

import com.master.application.model.ApplicationModel;
import com.master.application.model.ErrorModel;
import com.master.application.service.ApplicationService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/applications")
public class ApplicationController {

  @Autowired
  private ApplicationService applicationService;
  
  @GetMapping
  public List<ApplicationModel> getApplications() {
    return applicationService.getApplications();
  }
  
  @GetMapping("/{id}")
  public ApplicationModel getApplicationById(@PathVariable Long id) {
    return applicationService.getApplication(id);
  }
  
  @PostMapping
  public ApplicationModel createApplication(@RequestBody ApplicationModel applicationModel) {
    return applicationService.createApplication(applicationModel);
  }
  
  @PutMapping("/{id}")
  public ApplicationModel editApplication(@PathVariable Long id, @RequestBody ApplicationModel applicationModel) {
    return applicationService.editApplication(id, applicationModel);
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
   applicationService.deleteApplication(id);
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
