package com.master.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.master.application.dto.AuthToken;
import com.master.application.dto.LoginUser;
import com.master.application.jwt.TokenProvider;
import com.master.application.model.ErrorModel;
import com.master.application.model.UserModel;
import com.master.application.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private TokenProvider jwtTokenUtil;

  @Autowired
  private UserService userService;

  @GetMapping
  public List<UserModel> getUsers() {
    return userService.getUsers();
  }

  @GetMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public UserModel getUserById(@PathVariable Long id) {
    return userService.getUser(id);
  }

  @PostMapping(value = "/authenticate")
  public ResponseEntity<?> generateToken(@RequestBody LoginUser loginUser)
      throws AuthenticationException {

    final Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);
    final String token = jwtTokenUtil.generateToken(authentication);
    return ResponseEntity.ok(new AuthToken(token));
  }

  @PostMapping(value = "/register")
  public UserModel saveUser(@RequestBody UserModel user) {
    return userService.createUser(user);
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<ErrorModel> handleException(IllegalArgumentException exception) {
    ErrorModel errorModel = new ErrorModel();
    errorModel.setMessage(exception.getMessage());
    errorModel.setExceptionType(exception.getClass().getCanonicalName());
    return new ResponseEntity<ErrorModel>(errorModel, HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
