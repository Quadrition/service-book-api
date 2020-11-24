package com.binple.servicebook.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "clients")
public class Client extends Account {

  @NotBlank(message = "First name cannot be blank")
  @Size(max = 20, message = "First name cannot have more than 20 characters")
  @Column(nullable = false)
  private String firstName;

  @NotBlank(message = "Last name cannot be blank")
  @Size(max = 30, message = "Last name cannot have more than 30 characters")
  @Column(nullable = false)
  private String lastName;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "client_vehicles", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
  private Set<Vehicle> vehicles = new HashSet<>();

  protected Client() {
    super();
  }

  public Client(String email, String password, String firstName, String lastName) {
    super(email, password);
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public Set<Vehicle> getVehicles() {
    return vehicles;
  }
}
