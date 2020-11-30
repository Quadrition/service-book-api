package com.binple.servicebook.service;

import javax.naming.OperationNotSupportedException;

import com.binple.servicebook.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

  private final AccountRepository repository;

  @Autowired
  public ProfileService(AccountRepository repository) {
    this.repository = repository;
  }

  public ResponseEntity<Object> addVehicleService() throws OperationNotSupportedException {
    throw new OperationNotSupportedException();
  }

  public ResponseEntity<Object> removeVehicleService() throws OperationNotSupportedException {
    throw new OperationNotSupportedException();
  }
}
