/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.assignment.emp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.assignment.emp.model.AppResponceEntity;
import com.assignment.emp.model.RespError;

/**
 *
 * @author Pramod.Jadhav
 */
public abstract class AbstractController {


  protected ResponseEntity<AppResponceEntity> buildSuccessResponse(final Object payload,
      final String message, final HttpStatus httpStatus) {
    final AppResponceEntity respEntity = new AppResponceEntity();
    respEntity.setSuccess(true);
    respEntity.setMessage(message);
    respEntity.setPayload(payload);
    return new ResponseEntity<>(respEntity, httpStatus);
  }

}
