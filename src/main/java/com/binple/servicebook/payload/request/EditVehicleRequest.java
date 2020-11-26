package com.binple.servicebook.payload.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.binple.servicebook.model.VehicleType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EditVehicleRequest {

  @NotBlank(message = "Manufacturer cannot be blank")
  @Size(max = 50, message = "Manufacturer cannot have more than 50 characters")
  @JsonProperty("manufacturer")
  private String manufacturer;

  @NotBlank(message = "Model cannot be blank")
  @Size(max = 40, message = "Model cannot have more than 40 characters")
  @JsonProperty("model")
  private String model;

  @NotNull(message = "Year of production cannot be null")
  @Min(1850)
  @Max(2050)
  @JsonProperty("yearOfProduction")
  private Short yearOfProduction;

  @NotNull(message = "Engine power cannot be null")
  @Min(0)
  @Max(1000)
  @JsonProperty("enginePower")
  private Short enginePower;

  @NotNull(message = "Engine displacement cannot be null")
  @Min(0)
  @Max(10000)
  @JsonProperty("engineDisplacement")
  private Short engineDisplacement;

  @NotNull(message = "Type cannot be null")
  @JsonProperty("type")
  private VehicleType type;

  @NotNull(message = "Chassis number cannot be null")
  @Pattern(regexp = "^[a-zA-Z0-9]{17}$", message = "Chassis number must be valid")
  @JsonProperty("chassisNumber")
  private String chassisNumber;

  protected EditVehicleRequest() {

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
