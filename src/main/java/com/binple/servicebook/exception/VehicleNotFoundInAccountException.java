package com.binple.servicebook.exception;

public class VehicleNotFoundInAccountException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public VehicleNotFoundInAccountException(String message) {
    super(message);
  }
}