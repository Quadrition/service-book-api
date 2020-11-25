package com.binple.servicebook.service;

import javax.naming.OperationNotSupportedException;

import com.binple.servicebook.repository.VehicleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

  private final VehicleRepository repository;

  @Autowired
  public VehicleService(VehicleRepository repository) {
    this.repository = repository;
  }

  public ResponseEntity<Object> insert() throws OperationNotSupportedException {
    throw new OperationNotSupportedException();
  }

  public ResponseEntity<Object> update() throws OperationNotSupportedException {
    throw new OperationNotSupportedException();
  }

  public ResponseEntity<Object> search() throws OperationNotSupportedException {
    throw new OperationNotSupportedException();
  }
}
