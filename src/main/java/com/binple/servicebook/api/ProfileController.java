package com.binple.servicebook.api;

import javax.naming.OperationNotSupportedException;

import com.binple.servicebook.service.ProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {

  private final ProfileService service;

  @Autowired
  public ProfileController(ProfileService service) {
    this.service = service;
  }

  @PostMapping("/add-vehicle")
  public ResponseEntity<Void> addVehicle(@RequestParam Long vehicleId) {
    return service.addVehicle(vehicleId);
  }

  @PostMapping
  public ResponseEntity<Object> removeVehicleService() throws OperationNotSupportedException {
    return service.removeVehicleService();
  }
}
