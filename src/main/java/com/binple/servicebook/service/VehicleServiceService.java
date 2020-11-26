package com.binple.servicebook.service;

import javax.naming.OperationNotSupportedException;

import com.binple.servicebook.repository.VehicleServiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceService {

  private final VehicleServiceRepository repository;

  @Autowired
  public VehicleServiceService(VehicleServiceRepository repository) {
    this.repository = repository;
  }

  public ResponseEntity<Object> insert() throws OperationNotSupportedException {
    throw new OperationNotSupportedException();
  }

  public ResponseEntity<Object> update() throws OperationNotSupportedException {
    throw new OperationNotSupportedException();
  }

  public ResponseEntity<Object> select() throws OperationNotSupportedException {
    throw new OperationNotSupportedException();
  }
}
