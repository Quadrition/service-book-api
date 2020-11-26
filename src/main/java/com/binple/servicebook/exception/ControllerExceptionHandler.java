package com.binple.servicebook.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(VehicleAlreadyExistsException.class)
  protected ResponseEntity<String> handleVehicleAlreadyExistsException(VehicleAlreadyExistsException ex,
      WebRequest request) {

    return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {

    return new ResponseEntity<>(ex.getBindingResult().getAllErrors(), HttpStatus.BAD_REQUEST);
  }
}
