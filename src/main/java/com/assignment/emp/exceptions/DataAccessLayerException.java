package com.assignment.emp.exceptions;

public class DataAccessLayerException extends ApplicaionException {

  public DataAccessLayerException() {}

  public DataAccessLayerException(final String message) {
    super(message);
  }

  public DataAccessLayerException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public DataAccessLayerException(final Throwable cause) {
    super(cause);
  }

}
