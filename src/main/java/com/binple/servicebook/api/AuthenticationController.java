package com.binple.servicebook.api;

import javax.naming.OperationNotSupportedException;
import javax.validation.Valid;

import com.binple.servicebook.payload.request.AccountRegisterRequest;
import com.binple.servicebook.payload.response.AccountRegisterResponse;
import com.binple.servicebook.service.AuthenticationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
  public ResponseEntity<AccountRegisterResponse> register(@RequestBody @Valid AccountRegisterRequest request) {
    return service.register(request);
  }

  @PostMapping("/login")
  public ResponseEntity<Object> login() throws OperationNotSupportedException {
    return service.login();
  }
}
