package com.binple.servicebook.payload.response;

import com.binple.servicebook.model.VehicleServiceType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SelectVehicleServiceResponse {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("type")
  private VehicleServiceType type;

  @JsonProperty("description")
  private String description;

  @JsonProperty("date")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private java.time.LocalDate date;

  @JsonProperty("serviceStation")
  private ServiceStationResponse serviceStation;

  protected SelectVehicleServiceResponse() {

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
