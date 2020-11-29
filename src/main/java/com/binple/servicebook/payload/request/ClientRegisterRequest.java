package com.binple.servicebook.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientRegisterRequest extends AccountRegisterRequest {

  @NotBlank(message = "First name cannot be blank")
  @Size(max = 20, message = "First name cannot have more than 20 characters")
  @JsonProperty("firstName")
  private String firstName;

  @NotBlank(message = "Last name cannot be blank")
  @Size(max = 30, message = "Last name cannot have more than 30 characters")
  @JsonProperty("lastName")
  private String lastName;

  protected ClientRegisterRequest() {

  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }
}
