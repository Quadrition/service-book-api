package com.binple.servicebook.service;

import java.util.Optional;

import javax.naming.OperationNotSupportedException;

import com.binple.servicebook.exception.AccountAlreadyExistsException;
import com.binple.servicebook.model.Account;
import com.binple.servicebook.model.ServiceStation;
import com.binple.servicebook.payload.request.ServiceStationRegisterRequest;
import com.binple.servicebook.payload.response.ServiceStationRegisterResponse;
import com.binple.servicebook.repository.AccountRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdministrationService {

  private final AccountRepository repository;
  private final ModelMapper modelMapper;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  public AdministrationService(AccountRepository repository, ModelMapper modelMapper,
      BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.repository = repository;
    this.modelMapper = modelMapper;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  public ResponseEntity<ServiceStationRegisterResponse> registerServiceStation(ServiceStationRegisterRequest request) {
    Optional<Account> entity = repository.findByEmail(request.getEmail());

    if (entity.isPresent()) {
      throw new AccountAlreadyExistsException("Account with the given email already exists");
    }

    Account account = modelMapper.map(request, ServiceStation.class);
    account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
    repository.save(account);

    return new ResponseEntity<>(modelMapper.map(account, ServiceStationRegisterResponse.class), HttpStatus.CREATED);
  }

  public ResponseEntity<Object> registerAdministrator() throws OperationNotSupportedException {
    throw new OperationNotSupportedException();
  }
}
