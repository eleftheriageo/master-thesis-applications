package com.master.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.master.application.entity.Application;
import com.master.application.entity.ApplicationRanking;
import com.master.application.entity.User;
import com.master.application.model.ApplicationRankingModel;
import com.master.application.repository.ApplicationRankingRepository;
import com.master.application.repository.ApplicationRepository;
import com.master.application.repository.UserRepository;

@Service
public class ApplicationRankingService {
  @Autowired
  private ApplicationRepository applicationRepository;

  @Autowired
  private ApplicationRankingRepository applicationRankingRepository;

  @Autowired
  private UserRepository userRepository;

  @Transactional(readOnly = true)
  public ApplicationRankingModel getApplicationRanking(Long id) {
    Optional<ApplicationRanking> optionalApplicationRanking = applicationRankingRepository
        .findById(id);
    if (optionalApplicationRanking.isPresent()) {
      return new ApplicationRankingModel(optionalApplicationRanking.get());
    } else {
      throw new IllegalArgumentException("Application id " + id + " does not exist");
    }
  }

  @Transactional(readOnly = true)
  public List<ApplicationRankingModel> getApplicationRankings() {
    List<ApplicationRanking> applicationRankings = applicationRankingRepository.findAll();
    return applicationRankings.stream().map(ApplicationRankingModel::new)
        .collect(Collectors.toList());
  }

  @Transactional
  public List<ApplicationRankingModel> createApplicationRanking(ApplicationRankingModel model) {
    List<ApplicationRankingModel> models = new ArrayList<>();
    Optional<Application> application = applicationRepository.findById(model.getApplication_id());
    for (Long professorId : model.getProfessors_id()) {
      Optional<User> teacher = userRepository.findById(professorId);
      if (application.isPresent() && teacher.isPresent()) {
        ApplicationRanking applicationRanking = new ApplicationRanking();
        applicationRanking.setApplication(application.get());
        applicationRanking.setTeacher(teacher.get());
        applicationRanking.setRank(model.getRank());
        models.add(new ApplicationRankingModel(applicationRankingRepository.save(applicationRanking)));
      } else {
        throw new IllegalArgumentException("Application or teacher not found");
      }
    }

    return models;
  }

  @Transactional
	  public ApplicationRankingModel editApplicationRanking(Long id, ApplicationRankingModel model,List<Long> professors_id) {
	    // To Optional kanei wrap to antikeimeno kai voithaei na apofeugoume
	    // null pointer exceptions
	    Optional<ApplicationRanking> optionalApplicationRanking = applicationRankingRepository.findById(id);
	    if (optionalApplicationRanking.isPresent()) {
	      Optional<Application> application = applicationRepository.findById(model.getApplication_id());
	      
	      ApplicationRanking applicationRanking = optionalApplicationRanking.get();
		    applicationRanking.setApplication(application.get());
		    applicationRanking.setRank(model.getRank());
	     
	      return new ApplicationRankingModel(applicationRankingRepository.save(applicationRanking));
	    } else {
	      throw new IllegalArgumentException("Application id " + id + " does not exist");
	    }
	  }
  @Transactional
  public void deleteApplicationRanking(Long id) {
    applicationRankingRepository.deleteById(id);
  }
}
