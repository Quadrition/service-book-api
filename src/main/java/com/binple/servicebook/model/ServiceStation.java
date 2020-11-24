package com.binple.servicebook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "servicestations")
public class ServiceStation extends Account {

  @NotBlank(message = "Name cannot be blank")
  @Size(max = 50, message = "Name cannot have more than 50 characters")
  @Column(nullable = false)
  private String name;

  @NotBlank(message = "Address cannot be blank")
  @Size(max = 50, message = "Address cannot have more than 50 characters")
  @Column(nullable = false)
  private String address;

  @NotBlank(message = "City cannot be blank")
  @Size(max = 30, message = "City cannot have more than 30 characters")
  @Column(nullable = false)
  private String city;

  @Pattern(regexp = "/^.+\\.(jpg|jpeg|png)$/i", message = "Image name must be valid")
  @Size(max = 64, message = "Image name cannot have more than 64 characters")
  @Column(nullable = true)
  private String imageName;

  protected ServiceStation() {
    super();
  }

  public ServiceStation(String email, String password, String name, String address, String city, String imageName) {
    super(email, password);
    this.name = name;
    this.address = address;
    this.city = city;
    this.imageName = imageName;
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
