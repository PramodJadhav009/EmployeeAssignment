/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.assignment.emp.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.assignment.emp.model.RespError;

/**
 *
 * @author Pramod.Jadhav
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  private ResponseEntity<Object> buildResponseEntity(final RespError apiError) {
    return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
  }

  // other exception handlers
  @ExceptionHandler(ApplicaionException.class)
  protected ResponseEntity<Object> handleApplicationException(final ApplicaionException ex) {
    final RespError apiError = new RespError();
    apiError.setMessage(ex.getMessage());
    apiError.setCode(400);
    return buildResponseEntity(apiError);
  }
}
