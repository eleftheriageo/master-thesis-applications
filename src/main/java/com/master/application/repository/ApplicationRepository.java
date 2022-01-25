package com.master.application.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.master.application.entity.Application;

@Repository
public interface ApplicationRepository extends CrudRepository<Application, Long>{

  List<Application> findAll();
}
