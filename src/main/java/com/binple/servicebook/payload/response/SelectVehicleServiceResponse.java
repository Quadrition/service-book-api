package com.binple.servicebook.payload.response;

import com.binple.servicebook.model.VehicleServiceType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SelectVehicleServiceResponse {

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

  public class ServiceStationResponse {

    @JsonProperty("name")
    private String name;

    @JsonProperty("address")
    private String address;

    @JsonProperty("city")
    private String city;

    @JsonProperty("imageName")
    private String imageName;

    protected ServiceStationResponse() {

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
}
