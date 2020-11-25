package com.binple.servicebook.api;

import javax.naming.OperationNotSupportedException;

import com.binple.servicebook.service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

  private final VehicleService service;

  @Autowired
  public VehicleController(VehicleService service) {
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

  @GetMapping("/search")
  public ResponseEntity<Object> search() throws OperationNotSupportedException {
    return service.search();
  }
}
