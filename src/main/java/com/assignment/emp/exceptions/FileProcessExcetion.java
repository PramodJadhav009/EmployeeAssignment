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
public class FileProcessExcetion extends ApplicaionException {

  public FileProcessExcetion() {}

  public FileProcessExcetion(final String message) {
    super(message);
  }

  public FileProcessExcetion(final String message, final ApplicaionExceptionErrorCodes errorCodes) {
    super(message, errorCodes);
  }

  public FileProcessExcetion(final String message, final Throwable cause) {
    super(message, cause);
  }

  public FileProcessExcetion(final String message, final Throwable cause,
      final boolean enableSuppression, final boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public FileProcessExcetion(final Throwable cause) {
    super(cause);
  }

}
