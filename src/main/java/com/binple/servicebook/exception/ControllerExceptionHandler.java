package com.binple.servicebook.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(VehicleAlreadyExistsException.class)
  protected ResponseEntity<Object> handleVehicleAlreadyExistsException(VehicleAlreadyExistsException ex,
      WebRequest request) {

    return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
  }

  @ExceptionHandler(VehicleNotFoundException.class)
  protected ResponseEntity<Object> handleVehicleNotFoundException(VehicleNotFoundException ex, WebRequest request) {

    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(VehicleServiceNotFoundException.class)
  protected ResponseEntity<Object> handleVehicleServiceNotFoundException(VehicleServiceNotFoundException ex,
      WebRequest request) {

    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(AccountAlreadyExistsException.class)
  protected ResponseEntity<Object> handleAccountAlreadyExistsException(AccountAlreadyExistsException ex,
      WebRequest request) {

    return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
  }

  @ExceptionHandler(AccountNotFoundException.class)
  protected ResponseEntity<Object> handleAccountNotFoundException(AccountNotFoundException ex, WebRequest request) {

    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(EditVehicleServiceNotAllowedException.class)
  protected ResponseEntity<Object> handleServiceStationNotAllowedException(EditVehicleServiceNotAllowedException ex,
      WebRequest request) {

    return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
  }

  @ExceptionHandler(VehicleNotFoundInAccountException.class)
  protected ResponseEntity<Object> handleVehicleNotFoundInAccountException(VehicleNotFoundInAccountException ex,
      WebRequest request) {

    return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
  }

  @ExceptionHandler(VehicleAlreadyInAccountException.class)
  protected ResponseEntity<Object> handleVehicleAlreadyInAccountException(VehicleAlreadyInAccountException ex,
      WebRequest request) {

    return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  protected ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex,
      WebRequest request) {
    // TODO not working
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {

    return new ResponseEntity<>(ex.getBindingResult().getAllErrors(), HttpStatus.BAD_REQUEST);
  }

  @Override
  protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {

    return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
  }
}
