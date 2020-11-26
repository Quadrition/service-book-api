package com.binple.servicebook.api;

import javax.naming.OperationNotSupportedException;

import com.binple.servicebook.service.VehicleServiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicle-service")
public class VehicleServiceController {

  private final VehicleServiceService service;

  @Autowired
  public VehicleServiceController(VehicleServiceService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<Object> insert() throws OperationNotSupportedException {
    return service.insert();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> update() throws OperationNotSupportedException {
    return service.update();
  }

  @GetMapping("/all")
  public ResponseEntity<Object> select() throws OperationNotSupportedException {
    return service.select();
  }
}
