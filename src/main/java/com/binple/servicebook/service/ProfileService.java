package com.binple.servicebook.service;

import java.util.Optional;

import com.binple.servicebook.exception.AccountNotFoundException;
import com.binple.servicebook.exception.VehicleAlreadyInAccountException;
import com.binple.servicebook.exception.VehicleNotFoundException;
import com.binple.servicebook.exception.VehicleNotFoundInAccountException;
import com.binple.servicebook.model.Account;
import com.binple.servicebook.model.Client;
import com.binple.servicebook.model.Vehicle;
import com.binple.servicebook.repository.AccountRepository;
import com.binple.servicebook.repository.VehicleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

  private final AccountRepository repository;
  private final VehicleRepository vehicleRepository;

  @Autowired
  public ProfileService(AccountRepository repository, VehicleRepository vehicleRepository) {
    this.repository = repository;
    this.vehicleRepository = vehicleRepository;
  }

  public ResponseEntity<Void> addVehicle(Long vehicleId) {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    Optional<Account> accountEntity = repository.findByEmail(user.getUsername());
    if (!accountEntity.isPresent()) {
      throw new AccountNotFoundException("Provided account is not found in the database");
    }

    Client client = (Client) accountEntity.get();

    Optional<Vehicle> vehicleEntity = vehicleRepository.findById(vehicleId);
    if (!vehicleEntity.isPresent()) {
      throw new VehicleNotFoundException("Vehicle with the given id not found");
    }

    Vehicle vehicle = vehicleEntity.get();

    if (client.getVehicles().contains(vehicle)) {
      throw new VehicleAlreadyInAccountException("Vehicle with the given id is already in provided account");
    }

    client.getVehicles().add(vehicle);
    repository.save(client);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  public ResponseEntity<Void> removeVehicle(Long vehicleId) {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    Optional<Account> accountEntity = repository.findByEmail(user.getUsername());
    if (!accountEntity.isPresent()) {
      throw new AccountNotFoundException("Provided account is not found in the database");
    }

    Client client = (Client) accountEntity.get();

    Optional<Vehicle> vehicleEntity = vehicleRepository.findById(vehicleId);
    if (!vehicleEntity.isPresent()) {
      throw new VehicleNotFoundException("Vehicle with the given id not found");
    }

    Vehicle vehicle = vehicleEntity.get();

    if (!client.getVehicles().contains(vehicle)) {
      throw new VehicleNotFoundInAccountException("Vehicle with the given id not found in provided account");
    }

    client.getVehicles().remove(vehicle);
    repository.save(client);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
