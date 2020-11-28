package com.binple.servicebook.service;

import java.util.Optional;

import javax.naming.OperationNotSupportedException;

import com.binple.servicebook.exception.VehicleNotFoundException;
import com.binple.servicebook.exception.VehicleServiceNotFoundException;
import com.binple.servicebook.model.Vehicle;
import com.binple.servicebook.payload.request.EditVehicleServiceRequest;
import com.binple.servicebook.payload.request.NewVehicleServiceRequest;
import com.binple.servicebook.payload.response.EditVehicleServiceResponse;
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

  // TODO insert service station check
  public ResponseEntity<EditVehicleServiceResponse> update(Long id, EditVehicleServiceRequest request) {
    Optional<com.binple.servicebook.model.VehicleService> entity = repository.findById(id);

    if (!entity.isPresent()) {
      throw new VehicleServiceNotFoundException("Vehicle service with the given id does not exists");
    } else {
      com.binple.servicebook.model.VehicleService vehicleService = entity.get();
      modelMapper.map(request, vehicleService);

      repository.save(vehicleService);

      return new ResponseEntity<>(modelMapper.map(vehicleService, EditVehicleServiceResponse.class), HttpStatus.OK);
    }
  }

  public ResponseEntity<Object> select() throws OperationNotSupportedException {
    throw new OperationNotSupportedException();
  }
}
