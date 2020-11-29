package com.binple.servicebook.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientRegisterResponse {

  @JsonProperty("email")
  protected String email;

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("token")
  private String token;

  protected ClientRegisterResponse() {

  }

  public String getEmail() {
    return email;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
