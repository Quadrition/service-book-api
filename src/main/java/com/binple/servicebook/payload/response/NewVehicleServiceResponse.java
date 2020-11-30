package com.binple.servicebook.payload.response;

import com.binple.servicebook.model.VehicleServiceType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NewVehicleServiceResponse {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("type")
  private VehicleServiceType type;

  @JsonProperty("description")
  private String description;

  @JsonProperty("date")
  private java.time.LocalDate date;

  @JsonProperty("serviceStation")
  private ServiceStationResponse serviceStation;

  protected NewVehicleServiceResponse() {

  }

  public Long getId() {
    return id;
  }

  public VehicleServiceType getType() {
    return type;
  }

  public String getDescription() {
    return description;
  }

  public java.time.LocalDate getDate() {
    return date;
  }

  public ServiceStationResponse getServiceStation() {
    return serviceStation;
  }
}
