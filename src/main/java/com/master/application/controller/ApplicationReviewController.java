package com.master.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.master.application.model.ApplicationReviewModel;
import com.master.application.service.ApplicationReviewService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/applicationreviews")
public class ApplicationReviewController {
  
  @Autowired
  private ApplicationReviewService applicationReviewService;
  
  @GetMapping
  public List<ApplicationReviewModel> getApplicationReviews() {
    return applicationReviewService.getApplicationReviews();
  }
  
  @GetMapping("/{id}")
  public ApplicationReviewModel getApplicationReviewById(@PathVariable Long id) {
    return applicationReviewService.getApplicationReview(id);
  }
  
  @PostMapping
  public ApplicationReviewModel createApplicationReview(@RequestBody ApplicationReviewModel applicationReviewModel) {
    System.out.println(applicationReviewModel);
    return applicationReviewService.createApplicationReview(applicationReviewModel);
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteApplicationReview(@PathVariable Long id) {
    applicationReviewService.deleteApplicationReview(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
