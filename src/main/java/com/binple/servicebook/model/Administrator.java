package com.binple.servicebook.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "administrators")
public class Administrator extends Account {

  protected Administrator() {
    super();
  }

  public Administrator(String email, String password) {
    super(email, password);
  }
}
