package com.binple.servicebook.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.binple.servicebook.exception.VehicleAlreadyExistsException;
import com.binple.servicebook.exception.VehicleNotFoundException;
import com.binple.servicebook.model.Vehicle;
import com.binple.servicebook.payload.request.EditVehicleRequest;
import com.binple.servicebook.payload.request.NewVehicleRequest;
import com.binple.servicebook.payload.response.EditVehicleResponse;
import com.binple.servicebook.payload.response.NewVehicleResponse;
import com.binple.servicebook.payload.response.SearchVehicleResponse;
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

  public ResponseEntity<EditVehicleResponse> update(Long id, EditVehicleRequest request) {
    Optional<Vehicle> entity = repository.findById(id);

    if (!entity.isPresent()) {
      throw new VehicleNotFoundException("Vehicle with the given id not found");
    } else {
      Optional<Vehicle> duplicate = repository.findByChassisNumberAndIdNot(request.getChassisNumber(), id);

      if (duplicate.isPresent()) {
        throw new VehicleAlreadyExistsException("Vehicle with the given chassis number already exists");
      } else {
        Vehicle vehicle = entity.get();
        modelMapper.map(request, vehicle);

        repository.save(vehicle);

        return new ResponseEntity<>(modelMapper.map(vehicle, EditVehicleResponse.class), HttpStatus.OK);
      }
    }
  }

  public ResponseEntity<Set<SearchVehicleResponse>> search(String pattern) {

    Set<Vehicle> vehicles = repository.findByChassisNumberContaining(pattern);

    return new ResponseEntity<>(vehicles.stream().map(vehicle -> modelMapper.map(vehicle, SearchVehicleResponse.class))
        .collect(Collectors.toSet()), HttpStatus.OK);
  }
}
