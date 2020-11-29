package com.binple.servicebook.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ServiceStationRegisterRequest extends AccountRegisterRequest {

  @NotBlank(message = "Name cannot be blank")
  @Size(max = 50, message = "Name cannot have more than 50 characters")
  private String name;

  @NotBlank(message = "Address cannot be blank")
  @Size(max = 50, message = "Address cannot have more than 50 characters")
  private String address;

  @NotBlank(message = "City cannot be blank")
  @Size(max = 30, message = "City cannot have more than 30 characters")
  private String city;

  @NotBlank(message = "Image name cannot be blank")
  @Pattern(regexp = "^.+\\.(jpg|jpeg|png)$", message = "Image name must be valid")
  @Size(max = 64, message = "Image name cannot have more than 64 characters")
  private String imageName;

  protected ServiceStationRegisterRequest() {

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

  public String getImageName() {
    return imageName;
  }
}
