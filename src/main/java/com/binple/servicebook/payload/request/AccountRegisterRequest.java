package com.binple.servicebook.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountRegisterRequest {

  @Email(message = "Email must be valid")
  @Size(max = 50, message = "Email cannot have more than 50 characters")
  @JsonProperty("email")
  protected String email;

  @NotBlank(message = "Password cannot be blank")
  @Size(max = 60, message = "Password cannot have more than 60 characters")
  @JsonProperty("password")
  protected String password;

  @NotBlank(message = "First name cannot be blank")
  @Size(max = 20, message = "First name cannot have more than 20 characters")
  @JsonProperty("firstName")
  private String firstName;

  @NotBlank(message = "Last name cannot be blank")
  @Size(max = 30, message = "Last name cannot have more than 30 characters")
  @JsonProperty("lastName")
  private String lastName;

  protected AccountRegisterRequest() {

  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }
}
