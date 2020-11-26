package com.binple.servicebook.service;

import java.util.Optional;

import javax.naming.OperationNotSupportedException;

import com.binple.servicebook.exception.VehicleAlreadyExistsException;
import com.binple.servicebook.model.Vehicle;
import com.binple.servicebook.payload.request.NewVehicleRequest;
import com.binple.servicebook.payload.response.NewVehicleResponse;
import com.binple.servicebook.repository.VehicleRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

  private final VehicleRepository repository;
  private final ModelMapper modelMapper;

  @Autowired
  public VehicleService(VehicleRepository repository, ModelMapper modelMapper) {
    this.repository = repository;
    this.modelMapper = modelMapper;
  }

  public ResponseEntity<NewVehicleResponse> insert(NewVehicleRequest request) {

    Optional<Vehicle> entity = repository.findByChassisNumber(request.getChassisNumber());

    if (entity.isPresent()) {
      throw new VehicleAlreadyExistsException("Vehicle with the given chassis number already exists");
    } else {
      Vehicle vehicle = modelMapper.map(request, Vehicle.class);
      repository.save(vehicle);

      return new ResponseEntity<>(modelMapper.map(vehicle, NewVehicleResponse.class), HttpStatus.CREATED);
    }
  }

  public ResponseEntity<Object> update() throws OperationNotSupportedException {
    throw new OperationNotSupportedException();
  }

  public ResponseEntity<Object> search() throws OperationNotSupportedException {
    throw new OperationNotSupportedException();
  }
}
