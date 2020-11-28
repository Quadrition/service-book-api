package com.binple.servicebook.exception;

public class VehicleServiceNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public VehicleServiceNotFoundException(String message) {
    super(message);
  }
}