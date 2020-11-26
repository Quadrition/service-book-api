package com.binple.servicebook.exception;

public class VehicleAlreadyExistsException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public VehicleAlreadyExistsException(String message) {
    super(message);
  }
}
