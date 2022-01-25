package com.master.application.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.master.application.entity.Master;
import com.master.application.model.MasterModel;
import com.master.application.repository.MasterRepository;

@Service
public class MasterService {

  @Autowired
  private MasterRepository masterRepository;

  @Transactional(readOnly = true)
  public MasterModel getMaster(Long id) {
    Optional<Master> optionalMaster = masterRepository.findById(id);
    if (optionalMaster.isPresent()) {
      return new MasterModel(optionalMaster.get());
    } else {
      throw new IllegalArgumentException("Master id " + id + " does not exist");
    }
  }

  @Transactional(readOnly = true)
  public List<MasterModel> getMasters() {
    List<Master> masters = masterRepository.findAll();
    return masters.stream().map(MasterModel::new).collect(Collectors.toList());

  }

  @Transactional
  public MasterModel createMaster(MasterModel model) {
    Master master = new Master();
    master.setId(model.getId());
    master.setName(model.getName());

    return new MasterModel(masterRepository.save(master));
  }

  @Transactional
  public void deleteMaster(Long id) {
    masterRepository.deleteById(id);
  }

  @Transactional
  public MasterModel editMaster(Long id, MasterModel model) {
    // To Optional kanei wrap to antikeimeno kai voithaei na apofeugoume
    // null pointer exceptions
    Optional<Master> optionalMaster = masterRepository.findById(id);
    if (optionalMaster.isPresent()) {
      Master master = optionalMaster.get();
      master.setName(model.getName());
      return new MasterModel(masterRepository.save(master));

    } else {
      throw new IllegalArgumentException("Application id " + id + " does not exist");
    }
  }
  
  
}
