package com.master.application.dto;

public class AuthToken {
  private Long id;
  private String token;
  private String username;
  private String type;
  public AuthToken() {

  }

  public AuthToken(Long id, String token, String username, String type) {
    this.id = id;
    this.token = token;
    this.username = username;
    this.type = type;
  }

  public AuthToken(String token) {
    this.token = token;
  }

  /**
   * @return the token
   */
  public String getToken() {
    return token;
  }

  /**
   * @param token the token to set
   */
  public void setToken(String token) {
    this.token = token;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
