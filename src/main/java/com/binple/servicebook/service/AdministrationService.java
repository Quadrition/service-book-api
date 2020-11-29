package com.binple.servicebook.service;

import javax.naming.OperationNotSupportedException;

import com.binple.servicebook.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdministrationService {

  private final AccountRepository repository;

  @Autowired
  public AdministrationService(AccountRepository repository) {
    this.repository = repository;
  }

  public ResponseEntity<Object> registerServiceStation() throws OperationNotSupportedException {
    throw new OperationNotSupportedException();
  }

  public ResponseEntity<Object> registerAdministrator() throws OperationNotSupportedException {
    throw new OperationNotSupportedException();
  }
}
