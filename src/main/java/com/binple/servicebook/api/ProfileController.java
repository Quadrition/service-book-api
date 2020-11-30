package com.binple.servicebook.api;

import com.binple.servicebook.service.ProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

  @PreAuthorize("hasRole('CLIENT')")
  @PostMapping("/add-vehicle")
  public ResponseEntity<Void> addVehicle(@RequestParam Long vehicleId) {
    return service.addVehicle(vehicleId);
  }

  @PreAuthorize("hasRole('CLIENT')")
  @PostMapping("/remove-vehicle")
  public ResponseEntity<Void> removeVehicle(@RequestParam Long vehicleId) {
    return service.removeVehicle(vehicleId);
  }
}
