package com.kimjieun99.jpl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class TodoJpa {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int no;

  @Column(nullable = true, updatable = false, length = 300, unique = true)
  private String todo;

  private int done;
  private String pickedDate;
}
