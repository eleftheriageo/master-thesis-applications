package com.master.application.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.master.application.entity.Application;
import com.master.application.entity.ApplicationReview;
import com.master.application.entity.User;
import com.master.application.model.ApplicationReviewModel;
import com.master.application.repository.ApplicationRepository;
import com.master.application.repository.ApplicationReviewRepository;
import com.master.application.repository.UserRepository;

@Service
public class ApplicationReviewService {

  @Autowired
  private ApplicationReviewRepository applicationReviewRepository;

  @Autowired
  private UserRepository userRepository;
  
  
  @Autowired
  private ApplicationRepository applicationRepository;

  @Transactional(readOnly = true)
  public List<ApplicationReviewModel> getApplicationReviews() {
    List<ApplicationReview> applicationreviews = applicationReviewRepository.findAll();
    return applicationreviews.stream().map(ApplicationReviewModel::new)
        .collect(Collectors.toList());
  }

  @Transactional(readOnly = true)
  public ApplicationReviewModel getApplicationReview(Long id) {
    Optional<ApplicationReview> optionalApplicationReview = applicationReviewRepository.findById(id);
    if (optionalApplicationReview.isPresent()) {
      return new ApplicationReviewModel(optionalApplicationReview.get());
    } else {
      throw new IllegalArgumentException("Application id " + id + " does not exist");
    }
  }
  
  @Transactional
  public ApplicationReviewModel createApplicationReview(ApplicationReviewModel model) {
    Optional<User> user = userRepository.findById(model.getSecretary_id());
    Optional<Application> application = applicationRepository.findById(model.getApplication_id());

    ApplicationReview applicationReview = new ApplicationReview();
    applicationReview.setAccepted(model.isAccepted());
    applicationReview.setSecretary(user.get());
    applicationReview.setApplication(application.get());

    return new ApplicationReviewModel(applicationReviewRepository.save(applicationReview));
  }
  
  @Transactional
  public void deleteApplicationReview(Long id) {
    applicationReviewRepository.deleteById(id);
  }

  }
  

