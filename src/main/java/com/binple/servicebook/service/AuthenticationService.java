package com.binple.servicebook.service;

import javax.naming.OperationNotSupportedException;

import com.binple.servicebook.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

  private final AccountRepository repository;

  @Autowired
  public AuthenticationService(AccountRepository repository) {
    this.repository = repository;
  }

  public ResponseEntity<Object> register() throws OperationNotSupportedException {
    throw new OperationNotSupportedException();
  }

  public ResponseEntity<Object> login() throws OperationNotSupportedException {
    throw new OperationNotSupportedException();
  }
}
