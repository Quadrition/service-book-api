package com.binple.servicebook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "accounts", uniqueConstraints = {
    @UniqueConstraint(columnNames = "email", name = "uniqueEmailConstraint") })
@Inheritance(strategy = InheritanceType.JOINED)
public class Account extends Model {

  @Email(message = "Email must be valid")
  @Size(max = 50, message = "Email cannot have more than 50 characters")
  @Column(nullable = false)
  protected String email;

  @NotBlank(message = "Password cannot be blank")
  @Size(max = 60, message = "Password cannot have more than 60 characters")
  @Column(columnDefinition = "BINARY(60)", nullable = false)
  protected String password;

  protected Account() {

  }

  public Account(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
