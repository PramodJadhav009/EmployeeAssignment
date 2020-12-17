package com.assignment.emp.model;

public class ResultEntity {

  public enum RESULT {
    SUCCESS(), FAIL(), EXCEPTION();
  }

  private Object entity;
  private Exception exception;
  private RESULT result;
  private String message;

  public Object getEntity() {
    return entity;
  }

  public Exception getException() {
    return exception;
  }

  public String getMessage() {
    return message;
  }

  public RESULT getResult() {
    return result;
  }

  public void setEntity(final Object entity) {
    this.entity = entity;
  }

  public void setException(final Exception exception) {
    this.exception = exception;
  }

  public void setMessage(final String message) {
    this.message = message;
  }

  public void setResult(final RESULT result) {
    this.result = result;
  }

}
