package com.master.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.master.application.model.ErrorModel;
import com.master.application.model.ReferralModel;
import com.master.application.service.ReferralService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/referrals")
public class ReferralController {

  @Autowired
  private ReferralService referralService;

  @GetMapping
  public List<ReferralModel> getReferrals() {
    return referralService.getReferrals();
  }

  @GetMapping("/{id}")
  public ReferralModel getReferralById(@PathVariable Long id) {
    return referralService.getReferral(id);
  }

  @PostMapping
  public ReferralModel createReferral(@RequestBody ReferralModel referralModel) {
    return referralService.createReferral(referralModel);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteReferral(@PathVariable Long id) {
    referralService.deleteReferral(id);
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
