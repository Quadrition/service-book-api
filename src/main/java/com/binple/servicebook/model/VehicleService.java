package com.binple.servicebook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
@Table(name = "vehicleservices")
public class VehicleService extends Model {

  @NotNull(message = "Type cannot be null")
  @Enumerated(EnumType.STRING)
  @Column(length = 25)
  private VehicleServiceType type;

  @NotBlank(message = "Description cannot be blank")
  @Size(min = 10, max = 500, message = "Description must have between 10 and 500 characters")
  @Column(nullable = false)
  private String description;

  @Past(message = "Date must be in past")
  @NotNull(message = "Date cannot be null")
  private java.time.LocalDate date;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "servicestation_id")
  private ServiceStation serviceStation;

  protected VehicleService() {

  }

  public VehicleService(VehicleServiceType type, String description, java.time.LocalDate date,
      ServiceStation serviceStation) {
    this.type = type;
    this.description = description;
    this.date = date;
    this.serviceStation = serviceStation;
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

  public ServiceStation getServiceStation() {
    return serviceStation;
  }

  public void setServiceStation(ServiceStation serviceStation) {
    this.serviceStation = serviceStation;
  }
}