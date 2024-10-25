package com.obs.OBS.auth;

import com.obs.OBS.jobSeeker.CONTRACT;
import com.obs.OBS.user.UserType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class SignupRequest {

  @NotBlank(message = "First Name can't be empty")
  private String firstName;

  @NotBlank(message = "Last Name can't be empty")
  private String lastName;

  @NotBlank(message = "Phone number cann't be empty")
  private String phoneNumber;

  @NotBlank(message = "Email can't be empty")
  @Column(unique = true)
  private String email;

  @NotBlank(message = "Password can't be empty")
  private String password;

  private String confirmedPassword;

  private UserType role;

  @ElementCollection
  @Enumerated(EnumType.STRING)
  private Set<CONTRACT> contractType;

  @ElementCollection
  @CollectionTable(name = "SEEKER_LOCATIONS", joinColumns = @JoinColumn(name = "ID_USER"))
  private Set<String> desiredLocations;
}
