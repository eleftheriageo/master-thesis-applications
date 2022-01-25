package com.master.application.model;

public class ErrorModel {

  private String message;
  private String exceptionType;
  /**
   * @return the message
   */
  public String getMessage() {
    return message;
  }
  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }
  /**
   * @return the exceptionType
   */
  public String getExceptionType() {
    return exceptionType;
  }
  /**
   * @param exceptionType the exceptionType to set
   */
  public void setExceptionType(String exceptionType) {
    this.exceptionType = exceptionType;
  }
}
