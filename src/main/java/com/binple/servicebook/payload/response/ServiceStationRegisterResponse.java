package com.binple.servicebook.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServiceStationRegisterResponse {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("email")
  private String email;

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

  public Long getId() {
    return id;
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

  public String getImageName() {
    return imageName;
  }
}
