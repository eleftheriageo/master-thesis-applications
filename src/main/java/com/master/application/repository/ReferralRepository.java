package com.master.application.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.master.application.entity.Referral;

@Repository
public interface ReferralRepository extends CrudRepository<Referral, Long>{
  List<Referral> findAll();
}
