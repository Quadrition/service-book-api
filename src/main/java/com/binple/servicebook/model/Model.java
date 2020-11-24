package com.binple.servicebook.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;

  protected Model() {

  }

  public Long getId() {
    return id;
  }
}
