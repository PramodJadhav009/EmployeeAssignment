/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.assignment.emp.exceptions;

import com.assignment.emp.common.ApplicaionExceptionErrorCodes;

/**
 *
 * @author Pramod.Jadhav
 */
public class ApplicaionException extends Exception {

  private ApplicaionExceptionErrorCodes errorCodes;

  public ApplicaionException() {}

  public ApplicaionException(final String message) {
    super(message);
  }

  public ApplicaionException(final String message, final ApplicaionExceptionErrorCodes errorCodes) {
    super(message);
    this.errorCodes = errorCodes;
  }

  public ApplicaionException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public ApplicaionException(final String message, final Throwable cause,
      final boolean enableSuppression, final boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public ApplicaionException(final Throwable cause) {
    super(cause);
  }

}
