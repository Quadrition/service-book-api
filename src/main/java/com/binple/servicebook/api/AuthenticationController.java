package com.binple.servicebook.api;

import javax.validation.Valid;

import com.binple.servicebook.payload.request.AccountLoginRequest;
import com.binple.servicebook.payload.request.ClientRegisterRequest;
import com.binple.servicebook.payload.response.ClientRegisterResponse;
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
  public ResponseEntity<ClientRegisterResponse> register(@RequestBody @Valid ClientRegisterRequest request) {
    return service.register(request);
  }

  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody @Valid AccountLoginRequest request) {
    return service.login(request);
  }
}
