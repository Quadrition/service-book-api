package com.binple.servicebook.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.binple.servicebook.exception.AccountNotFoundException;
import com.binple.servicebook.exception.EditVehicleServiceNotAllowedException;
import com.binple.servicebook.exception.VehicleNotFoundException;
import com.binple.servicebook.exception.VehicleServiceNotFoundException;
import com.binple.servicebook.model.Account;
import com.binple.servicebook.model.ServiceStation;
import com.binple.servicebook.model.Vehicle;
import com.binple.servicebook.payload.request.EditVehicleServiceRequest;
import com.binple.servicebook.payload.request.NewVehicleServiceRequest;
import com.binple.servicebook.payload.response.EditVehicleServiceResponse;
import com.binple.servicebook.payload.response.NewVehicleServiceResponse;
import com.binple.servicebook.payload.response.SelectVehicleServiceResponse;
import com.binple.servicebook.repository.AccountRepository;
import com.binple.servicebook.repository.VehicleRepository;
import com.binple.servicebook.repository.VehicleServiceRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceService {

  private final VehicleServiceRepository repository;
  private final VehicleRepository vehicleRepository;
  private final AccountRepository accountRepository;
  private final ModelMapper modelMapper;

  @Autowired
  public VehicleServiceService(VehicleServiceRepository repository, VehicleRepository vehicleRepository,
      AccountRepository accountRepository, ModelMapper modelMapper) {
    this.repository = repository;
    this.vehicleRepository = vehicleRepository;
    this.accountRepository = accountRepository;
    this.modelMapper = modelMapper;
  }

  public ResponseEntity<NewVehicleServiceResponse> insert(Long vehicleId, NewVehicleServiceRequest request) {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    Optional<Account> entity = accountRepository.findByEmail(user.getUsername());

    if (!entity.isPresent()) {
      throw new AccountNotFoundException("Provided account is not found in the database");
    }

    ServiceStation serviceStation = (ServiceStation) entity.get();

    Optional<Vehicle> vehicleEntity = vehicleRepository.findById(vehicleId);

    if (!vehicleEntity.isPresent()) {
      throw new VehicleNotFoundException("Vehicle with the given id does not exists");
    } else {
      com.binple.servicebook.model.VehicleService vehicleService = modelMapper.map(request,
          com.binple.servicebook.model.VehicleService.class);
      vehicleService.setServiceStation(serviceStation);

      Vehicle vehicle = vehicleEntity.get();
      vehicle.getSevices().add(vehicleService);

      vehicleRepository.save(vehicle);

      return new ResponseEntity<>(modelMapper.map(vehicleService, NewVehicleServiceResponse.class), HttpStatus.CREATED);
    }
  }

  public ResponseEntity<EditVehicleServiceResponse> update(Long id, EditVehicleServiceRequest request) {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    Optional<Account> accountEntity = accountRepository.findByEmail(user.getUsername());

    if (!accountEntity.isPresent()) {
      throw new AccountNotFoundException("Provided account is not found in the database");
    }

    ServiceStation serviceStation = (ServiceStation) accountEntity.get();

    Optional<com.binple.servicebook.model.VehicleService> entity = repository.findById(id);

    if (!entity.isPresent()) {
      throw new VehicleServiceNotFoundException("Vehicle service with the given id does not exists");
    } else {
      com.binple.servicebook.model.VehicleService vehicleService = entity.get();

      if (vehicleService.getServiceStation() != serviceStation) {
        throw new EditVehicleServiceNotAllowedException(
            "Service station does not have an access to edit this vehicle service");
      }

      modelMapper.map(request, vehicleService);

      repository.save(vehicleService);

      return new ResponseEntity<>(modelMapper.map(vehicleService, EditVehicleServiceResponse.class), HttpStatus.OK);
    }
  }

  public ResponseEntity<Set<SelectVehicleServiceResponse>> select(Long vehicleId) {
    Optional<Vehicle> vehicleEntity = vehicleRepository.findById(vehicleId);

    if (!vehicleEntity.isPresent()) {
      throw new VehicleNotFoundException("Vehicle with the given id does not exists");
    } else {
      Vehicle vehicle = vehicleEntity.get();

      return new ResponseEntity<>(vehicle.getSevices().stream()
          .map(vehicleService -> modelMapper.map(vehicleService, SelectVehicleServiceResponse.class))
          .collect(Collectors.toSet()), HttpStatus.OK);
    }
  }
}
