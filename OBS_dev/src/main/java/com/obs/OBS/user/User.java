package com.obs.OBS.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "USER")
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class User {
  @Id
  @Column(name = "ID_USER")
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private String email;
  private String password;
  @Enumerated(EnumType.STRING)
  private UserType type;

  protected void setType(UserType type){
    this.type = type;
  }
}
