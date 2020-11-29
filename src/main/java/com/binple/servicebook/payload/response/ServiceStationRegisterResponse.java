package com.binple.servicebook.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServiceStationRegisterResponse {

  @JsonProperty("email")
  protected String email;

  @JsonProperty("name")
  private String name;

  @JsonProperty("address")
  private String address;

  @JsonProperty("city")
  private String city;

  @JsonProperty("imageName")
  private String imageName;

  protected ServiceStationRegisterResponse() {

  }

  public String getEmail() {
    return email;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getCity() {
    return city;
  }
}
