package com.master.application.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.master.application.entity.ApplicationRanking;

public interface ApplicationRankingRepository extends CrudRepository<ApplicationRanking, Long>{

	  List<ApplicationRanking> findAll();

}
