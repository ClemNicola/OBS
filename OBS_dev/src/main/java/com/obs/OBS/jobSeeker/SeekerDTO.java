package com.obs.OBS.jobSeeker;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import java.util.Set;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class SeekerDTO {
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String email;
  private String password;
  @Enumerated(EnumType.STRING)
  private CONTRACT contractType;
  @ElementCollection
  @CollectionTable(name = "SEEKER_LOCATIONS", joinColumns = @JoinColumn(name = "ID_SEEKER"))
  private Set<String> desiredLocations;
  private String description;


  public SeekerDTO() {
  }

  public SeekerDTO(String firstName, String lastName, String phoneNumber, String email, String password,
      CONTRACT contractType, Set<String> desiredLocations, String description) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.password = password;
    this.contractType = contractType;
    this.desiredLocations = desiredLocations;
    this.description = description;
  }
}
