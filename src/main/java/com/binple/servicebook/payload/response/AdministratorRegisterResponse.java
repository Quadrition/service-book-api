package com.binple.servicebook.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdministratorRegisterResponse {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("email")
  private String email;

  protected AdministratorRegisterResponse() {

  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }
}
