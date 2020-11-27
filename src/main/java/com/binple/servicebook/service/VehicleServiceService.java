package com.binple.servicebook.service;

import java.util.Optional;

import javax.naming.OperationNotSupportedException;

import com.binple.servicebook.exception.VehicleNotFoundException;
import com.binple.servicebook.model.Vehicle;
import com.binple.servicebook.payload.request.NewVehicleServiceRequest;
import com.binple.servicebook.payload.response.NewVehicleServiceResponse;
import com.binple.servicebook.repository.VehicleRepository;
import com.binple.servicebook.repository.VehicleServiceRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceService {

  private final VehicleServiceRepository repository;
  private final VehicleRepository vehicleRepository;
  private final ModelMapper modelMapper;

  @Autowired
  public VehicleServiceService(VehicleServiceRepository repository, VehicleRepository vehicleRepository,
      ModelMapper modelMapper) {
    this.repository = repository;
    this.vehicleRepository = vehicleRepository;
    this.modelMapper = modelMapper;
  }

  // TODO insert logged service station
  public ResponseEntity<NewVehicleServiceResponse> insert(Long vehicleId, NewVehicleServiceRequest request) {
    Optional<Vehicle> vehicleEntity = vehicleRepository.findById(vehicleId);

    if (!vehicleEntity.isPresent()) {
      throw new VehicleNotFoundException("Vehicle with the given id does not exists");
    } else {
      com.binple.servicebook.model.VehicleService vehicleService = modelMapper.map(request,
          com.binple.servicebook.model.VehicleService.class);

      Vehicle vehicle = vehicleEntity.get();
      vehicle.getSevices().add(vehicleService);

      vehicleRepository.save(vehicle);

      return new ResponseEntity<>(modelMapper.map(vehicleService, NewVehicleServiceResponse.class), HttpStatus.CREATED);
    }
  }

  public ResponseEntity<Object> update() throws OperationNotSupportedException {
    throw new OperationNotSupportedException();
  }

  public ResponseEntity<Object> select() throws OperationNotSupportedException {
    throw new OperationNotSupportedException();
  }
}
