package com.assignment.emp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/*
 * { "success": false, "payload": { Application-specific data would go here. }, "error": { "code":
 * 123, "message": "An error occurred!" } }
 */
@JsonInclude(Include.NON_NULL)
public class AppResponceEntity {

  private boolean success = false;
  private Object payload;
  private String message;
  private RespError error;

  public RespError getError() {
    return error;
  }

  public String getMessage() {
    return message;
  }

  public Object getPayload() {
    return payload;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setError(final RespError error) {
    this.error = error;
  }

  public void setMessage(final String message) {
    this.message = message;
  }

  public void setPayload(final Object payload) {
    this.payload = payload;
  }

  public void setSuccess(final boolean success) {
    this.success = success;
  }

}
