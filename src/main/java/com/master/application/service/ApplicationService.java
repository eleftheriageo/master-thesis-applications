package com.master.application.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.master.application.entity.Application;
import com.master.application.entity.Master;
import com.master.application.entity.Referral;
import com.master.application.entity.User;
import com.master.application.model.ApplicationModel;
import com.master.application.repository.ApplicationRepository;
import com.master.application.repository.MasterRepository;
import com.master.application.repository.ReferralRepository;
import com.master.application.repository.UserRepository;

@Service
public class ApplicationService {

  @Autowired
  private ApplicationRepository applicationRepository;

  @Autowired
  private ReferralRepository referralRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private MasterRepository masterRepository;

  @Transactional(readOnly = true)
  public ApplicationModel getApplication(Long id) {
    Optional<Application> optionalApplication = applicationRepository.findById(id);
    if (optionalApplication.isPresent()) {
      return new ApplicationModel(optionalApplication.get());
    } else {
      throw new IllegalArgumentException("Application id " + id + " does not exist");
    }
  }

  @Transactional(readOnly = true)
  public List<ApplicationModel> getApplications() {
    List<Application> applications = applicationRepository.findAll();
    return applications.stream().map(ApplicationModel::new).collect(Collectors.toList());
  }

  @Transactional
  public ApplicationModel createApplication(ApplicationModel model) {
    Optional<Master> master = masterRepository.findById(model.getMasterId());
    Optional<User> user = userRepository.findById(model.getStudentId());
    Optional<Referral> referral1 = referralRepository.findById(model.getReferralId1());
    Optional<Referral> referral2 = referralRepository.findById(model.getReferralId2());

    Application application = new Application();
    // to id??
    application.setBachelorTitle(model.getThesisTitle());
    application.setThesisDegree(model.getDegree());
    application.setMaster(master.get());
    application.setReferral1(referral1.get());
    application.setReferral2(referral2.get());
    application.setStudent(user.get());
    return new ApplicationModel(applicationRepository.save(application));
  }

  @Transactional
  public ApplicationModel editApplication(Long id, ApplicationModel model) {
    // To Optional kanei wrap to antikeimeno kai voithaei na apofeugoume
    // null pointer exceptions
    Optional<Application> optionalApplication = applicationRepository.findById(id);
    if (optionalApplication.isPresent()) {
      Optional<Master> master = masterRepository.findById(model.getMasterId());
      Optional<User> user = userRepository.findById(model.getStudentId());
      Optional<Referral> referral1 = referralRepository.findById(model.getReferralId1());
      Optional<Referral> referral2 = referralRepository.findById(model.getReferralId2());

      Application application = optionalApplication.get();
      application.setBachelorTitle(model.getThesisTitle());
      application.setThesisDegree(model.getDegree());
      application.setMaster(master.get());
      application.setReferral1(referral1.get());
      application.setReferral2(referral2.get());
      application.setStudent(user.get());
      return new ApplicationModel(applicationRepository.save(application));
    } else {
      throw new IllegalArgumentException("Application id " + id + " does not exist");
    }
  }
  @Transactional
  public void deleteApplication(Long id) {
    applicationRepository.deleteById(id);
  }
}
