package com.master.application.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.master.application.entity.Master;

@Repository
public interface MasterRepository extends CrudRepository<Master, Long>{

	List<Master>  findAll();
}
