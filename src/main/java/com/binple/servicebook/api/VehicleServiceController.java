package com.binple.servicebook.api;

import java.util.Set;

import javax.naming.OperationNotSupportedException;
import javax.validation.Valid;

import com.binple.servicebook.payload.request.EditVehicleServiceRequest;
import com.binple.servicebook.payload.request.NewVehicleServiceRequest;
import com.binple.servicebook.payload.response.EditVehicleServiceResponse;
import com.binple.servicebook.payload.response.NewVehicleServiceResponse;
import com.binple.servicebook.payload.response.SelectVehicleServiceResponse;
import com.binple.servicebook.service.VehicleServiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
  public ResponseEntity<NewVehicleServiceResponse> insert(@RequestParam Long vehicleId,
      @RequestBody @Valid NewVehicleServiceRequest request) {
    return service.insert(vehicleId, request);
  }

  @PutMapping("/{id}")
  public ResponseEntity<EditVehicleServiceResponse> update(@PathVariable Long id,
      @RequestBody @Valid EditVehicleServiceRequest request) {
    return service.update(id, request);
  }

  @GetMapping("/all")
  public ResponseEntity<Set<SelectVehicleServiceResponse>> select(@RequestParam Long vehicleId) {
    return service.select(vehicleId);
  }
}
