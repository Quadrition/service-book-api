package com.binple.servicebook.api;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import com.binple.servicebook.payload.request.EditVehicleRequest;
import com.binple.servicebook.payload.request.NewVehicleRequest;
import com.binple.servicebook.payload.response.EditVehicleResponse;
import com.binple.servicebook.payload.response.NewVehicleResponse;
import com.binple.servicebook.payload.response.SearchVehicleResponse;
import com.binple.servicebook.service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicle")
@Validated
public class VehicleController {

  private final VehicleService service;

  @Autowired
  public VehicleController(VehicleService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<NewVehicleResponse> insert(@RequestBody @Valid NewVehicleRequest request) {
    return service.insert(request);
  }

  @PutMapping("/{id}")
  public ResponseEntity<EditVehicleResponse> update(@PathVariable Long id,
      @RequestBody @Valid EditVehicleRequest request) {
    return service.update(id, request);
  }

  @GetMapping("/search")
  public ResponseEntity<Page<SearchVehicleResponse>> search(
      @RequestParam @Pattern(regexp = "^[a-zA-Z0-9]{5,}$") String pattern, Pageable pageable) {
    return service.search(pattern, pageable);
  }
}
