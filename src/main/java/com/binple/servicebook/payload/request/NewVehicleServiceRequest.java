package com.binple.servicebook.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.binple.servicebook.model.VehicleServiceType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NewVehicleServiceRequest {

  @NotNull(message = "Type cannot be null")
  @JsonProperty("type")
  private VehicleServiceType type;

  @NotBlank(message = "Description cannot be blank")
  @Size(min = 10, max = 500, message = "Description must have between 10 and 500 characters")
  @JsonProperty("description")
  private String description;

  @Past(message = "Date must be in past")
  @NotNull(message = "Date cannot be null")
  @JsonProperty("date")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private java.time.LocalDate date;

  protected NewVehicleServiceRequest() {

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
}
