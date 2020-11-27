package com.binple.servicebook.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "vehicles", uniqueConstraints = {
    @UniqueConstraint(columnNames = "chassisNumber", name = "uniqueChassisNumberConstraint") })
public class Vehicle extends Model {

  @NotBlank(message = "Manufacturer cannot be blank")
  @Size(max = 50, message = "Manufacturer cannot have more than 50 characters")
  @Column(nullable = false)
  private String manufacturer;

  @NotBlank(message = "Model cannot be blank")
  @Size(max = 40, message = "Model cannot have more than 40 characters")
  @Column(nullable = false)
  private String model;

  @NotNull(message = "Year of production cannot be null")
  @Min(1850)
  @Max(2050)
  private Short yearOfProduction;

  @NotNull(message = "Engine power cannot be null")
  @Min(0)
  @Max(1000)
  private Short enginePower;

  @NotNull(message = "Engine displacement cannot be null")
  @Min(0)
  @Max(10000)
  private Short engineDisplacement;

  @NotNull(message = "Type cannot be null")
  @Enumerated(EnumType.STRING)
  @Column(length = 15)
  private VehicleType type;

  @Pattern(regexp = "^[a-zA-Z0-9]{17}$", message = "Chassis number must be valid")
  @Column(nullable = false)
  private String chassisNumber;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "vehicle_id")
  private Set<VehicleService> services = new HashSet<>();

  protected Vehicle() {

  }

  public Vehicle(String manufacturer, String model, Short yearOfProduction, Short enginePower, Short engineDisplacement,
      VehicleType type, String chassisNumber) {
    this.manufacturer = manufacturer;
    this.model = model;
    this.yearOfProduction = yearOfProduction;
    this.enginePower = enginePower;
    this.engineDisplacement = engineDisplacement;
    this.type = type;
    this.chassisNumber = chassisNumber;
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

  public Set<VehicleService> getSevices() {
    return services;
  }
}