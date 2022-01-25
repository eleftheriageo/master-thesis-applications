package com.master.application.dto;

import com.master.application.entity.User;

public class UserDto {

  private String username;
  private String firstName;
  private String lastName;
  private String type;
  private String email;

  public User getUserFromDto() {
    User user = new User();
    user.setUsername(username);
    user.setFirstName(firstName);
    user.setLastName(lastName);
    user.setType(type);
    user.setEmail(email);

    return user;
  }
}
