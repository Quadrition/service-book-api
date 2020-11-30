package com.binple.servicebook.exception;

public class VehicleAlreadyInAccountException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public VehicleAlreadyInAccountException(String message) {
    super(message);
  }
}