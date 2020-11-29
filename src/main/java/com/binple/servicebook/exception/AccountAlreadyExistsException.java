package com.binple.servicebook.exception;

public class AccountAlreadyExistsException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public AccountAlreadyExistsException(String message) {
    super(message);
  }
}
