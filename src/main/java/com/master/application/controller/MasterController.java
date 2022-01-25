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

import com.master.application.model.ErrorModel;
import com.master.application.model.MasterModel;
import com.master.application.service.MasterService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/masters")
public class MasterController {

  @Autowired
  private MasterService masterService;

  @GetMapping
  public List<MasterModel> getMasters() {
    return masterService.getMasters();
  }

  @GetMapping("/{id}")
	  public MasterModel getMasterById(@PathVariable Long id) {
	    return masterService.getMaster(id);
  }

  @PostMapping
  public MasterModel createMaster(@RequestBody MasterModel masterModel) {
    return masterService.createMaster(masterModel);
  }

  @PutMapping("/{id}")
  public MasterModel editMaster(@PathVariable Long id, @RequestBody MasterModel masterModel) {
    return masterService.editMaster(id, masterModel);
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteMaster(@PathVariable Long id) {
    masterService.deleteMaster(id);
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
