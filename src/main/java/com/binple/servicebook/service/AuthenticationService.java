package com.binple.servicebook.service;

import static com.binple.servicebook.security.jwt.Constants.EXPIRATION_TIME;
import static com.binple.servicebook.security.jwt.Constants.PROVIDER;
import static com.binple.servicebook.security.jwt.Constants.SECREY_KEY;

import java.util.Date;
import java.util.Optional;

import com.binple.servicebook.exception.AccountAlreadyExistsException;
import com.binple.servicebook.model.Account;
import com.binple.servicebook.model.Client;
import com.binple.servicebook.payload.request.AccountLoginRequest;
import com.binple.servicebook.payload.request.ClientRegisterRequest;
import com.binple.servicebook.payload.response.ClientRegisterResponse;
import com.binple.servicebook.repository.AccountRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class AuthenticationService {

  private final AccountRepository repository;
  private final ModelMapper modelMapper;
  private final AuthenticationManager authenticationManager;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  public AuthenticationService(AccountRepository repository, ModelMapper modelMapper,
      AuthenticationManager authenticationManager, BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.repository = repository;
    this.modelMapper = modelMapper;
    this.authenticationManager = authenticationManager;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  public ResponseEntity<ClientRegisterResponse> register(ClientRegisterRequest request) {

    Optional<Account> entity = repository.findByEmail(request.getEmail());

    if (entity.isPresent()) {
      throw new AccountAlreadyExistsException("Account with the given email already exists");
    }

    Account account = modelMapper.map(request, Client.class);
    account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
    repository.save(account);

    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);

    String token = Jwts.builder().setIssuer(PROVIDER).setSubject(account.getEmail()).setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
        .signWith(SignatureAlgorithm.HS512, SECREY_KEY).compact();

    ClientRegisterResponse response = modelMapper.map(account, ClientRegisterResponse.class);
    response.setToken(token);

    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  public ResponseEntity<String> login(AccountLoginRequest request) {
    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);

    String token = Jwts.builder().setIssuer(PROVIDER).setSubject(request.getEmail()).setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
        .signWith(SignatureAlgorithm.HS512, SECREY_KEY).compact();

    return new ResponseEntity<>(token, HttpStatus.OK);
  }
}
