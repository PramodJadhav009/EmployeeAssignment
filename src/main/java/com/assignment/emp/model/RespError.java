/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.assignment.emp.model;

/**
 *
 * @author Pramod.Jadhav
 */
public class RespError {

  private int code;
  private String message;

  public RespError() {}

  public RespError(final int code, final String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  public void setCode(final int code) {
    this.code = code;
  }

  public void setMessage(final String message) {
    this.message = message;
  }

}
