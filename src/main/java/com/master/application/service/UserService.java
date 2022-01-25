package com.master.application.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.master.application.entity.User;
import com.master.application.model.UserModel;
import com.master.application.repository.UserRepository;

@Service(value = "userService")
public class UserService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;
  
  @Autowired
  private BCryptPasswordEncoder bcryptEncoder;

  @Transactional(readOnly = true)
  public UserModel getUser(Long id) {
    Optional<User> optionalUser = userRepository.findById(id);
    if (optionalUser.isPresent()) {
      return new UserModel(optionalUser.get());
    } else {
      throw new IllegalArgumentException("Application id " + id + " does not exist");
    }
  }

  @Transactional(readOnly = true)
  public List<UserModel> getUsers() {
    List<User> users = userRepository.findAll();
    return users.stream().map(UserModel::new).collect(Collectors.toList());
  }

  @Transactional
  public UserModel createUser(UserModel model) {
    User user = new User();
    user.setId(model.getId());
    user.setFirstName(model.getFirstName());
    user.setLastName(model.getLastName());
    user.setRole(model.getRole());
    user.setType(model.getType());
    user.setPassword(bcryptEncoder.encode(model.getPassword()));
    user.setEmail(model.getEmail());
    user.setUsername(model.getUsername());

    return new UserModel(userRepository.save(user));
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);
    if(user == null){
        throw new UsernameNotFoundException("Invalid username or password.");
    }
    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Set.of(new SimpleGrantedAuthority(user.getRole())));
  }

}
