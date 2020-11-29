package com.binple.servicebook.exception;

public class EditVehicleServiceNotAllowedException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public EditVehicleServiceNotAllowedException(String message) {
    super(message);
  }
}
