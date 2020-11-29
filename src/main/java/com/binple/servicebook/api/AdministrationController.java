package com.binple.servicebook.api;

import javax.naming.OperationNotSupportedException;
import javax.validation.Valid;

import com.binple.servicebook.payload.request.ServiceStationRegisterRequest;
import com.binple.servicebook.payload.response.ServiceStationRegisterResponse;
import com.binple.servicebook.service.AdministrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdministrationController {

  private final AdministrationService service;

  @Autowired
  public AdministrationController(AdministrationService service) {
    this.service = service;
  }

  @PostMapping("/register-service-station")
  public ResponseEntity<ServiceStationRegisterResponse> registerServiceStation(
      @RequestBody @Valid ServiceStationRegisterRequest request) {
    return service.registerServiceStation(request);
  }

  @PostMapping("/register-admin")
  public ResponseEntity<Object> registerAdministrator() throws OperationNotSupportedException {
    return service.registerAdministrator();
  }
}
