package com.master.application.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.master.application.entity.ApplicationReview;

//an den valw to annotation??
@Repository
public interface ApplicationReviewRepository extends CrudRepository<ApplicationReview, Long>{

	  List<ApplicationReview> findAll();

}
