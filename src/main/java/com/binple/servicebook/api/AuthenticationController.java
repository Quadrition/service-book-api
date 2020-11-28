package com.binple.servicebook.api;

import javax.naming.OperationNotSupportedException;

import com.binple.servicebook.service.AuthenticationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

  private final AuthenticationService service;

  @Autowired
  public AuthenticationController(AuthenticationService service) {
    this.service = service;
  }

  @PostMapping("/register")
  public ResponseEntity<Object> register() throws OperationNotSupportedException {
    return service.register();
  }

  @PostMapping("/login")
  public ResponseEntity<Object> login() throws OperationNotSupportedException {
    return service.login();
  }
}
