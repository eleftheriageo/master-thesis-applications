package com.master.application.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.master.application.entity.Referral;
import com.master.application.entity.User;
import com.master.application.model.ReferralModel;
import com.master.application.repository.ApplicationRepository;
import com.master.application.repository.MasterRepository;
import com.master.application.repository.ReferralRepository;
import com.master.application.repository.UserRepository;

@Service
public class ReferralService {
	 @Autowired
	  private ApplicationRepository applicationRepository;

	  @Autowired
	  private ReferralRepository referralRepository;

	  @Autowired
	  private UserRepository userRepository;

	  @Autowired
	  private MasterRepository masterRepository;

	  @Transactional(readOnly = true)
	  public ReferralModel getReferral(Long id) {
	    Optional<Referral> optionalReferral = referralRepository.findById(id);
	    if (optionalReferral.isPresent()) {
	      return new ReferralModel(optionalReferral.get());
	    } else {
	      throw new IllegalArgumentException("Application id " + id + " does not exist");
	    }
	  }

	  @Transactional(readOnly = true)
	  public List<ReferralModel> getReferrals() {
	    List<Referral> referrals = referralRepository.findAll();
	    return referrals.stream().map(ReferralModel::new).collect(Collectors.toList());
	  }

	  @Transactional
	  public ReferralModel createReferral(ReferralModel model) {
		  Optional<User> teacher = userRepository.findById(model.getProfessor_id());
	    Optional<User> student = userRepository.findById(model.getStudent_id());

	    Referral referral = new Referral();
	    
	    referral.setText(model.getText());
	    referral.setTeacher(teacher.get());
	    referral.setStudent(student.get());
	    return new ReferralModel(referralRepository.save(referral));
	  }
	  
	  @Transactional
	  public void deleteReferral(Long id) {
	    referralRepository.deleteById(id);
	  }


	
	  
	

}

