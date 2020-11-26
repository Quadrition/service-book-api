package com.binple.servicebook.payload.response;

import com.binple.servicebook.model.VehicleType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchVehicleResponse {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("manufacturer")
  private String manufacturer;

  @JsonProperty("model")
  private String model;

  @JsonProperty("yearOfProduction")
  private Short yearOfProduction;

  @JsonProperty("enginePower")
  private Short enginePower;

  @JsonProperty("engineDisplacement")
  private Short engineDisplacement;

  @JsonProperty("type")
  private VehicleType type;

  @JsonProperty("chassisNumber")
  private String chassisNumber;

  protected SearchVehicleResponse() {

  }

  public Long getId() {
    return id;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public String getModel() {
    return model;
  }

  public Short getYearOfProduction() {
    return yearOfProduction;
  }

  public Short getEnginePower() {
    return enginePower;
  }

  public Short getEngineDisplacement() {
    return engineDisplacement;
  }

  public VehicleType getType() {
    return type;
  }

  public String getChassisNumber() {
    return chassisNumber;
  }
}
