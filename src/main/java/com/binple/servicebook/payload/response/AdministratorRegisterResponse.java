package com.binple.servicebook.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdministratorRegisterResponse {

  @JsonProperty("email")
  protected String email;

  protected AdministratorRegisterResponse() {

  }

  public String getEmail() {
    return email;
  }
}
