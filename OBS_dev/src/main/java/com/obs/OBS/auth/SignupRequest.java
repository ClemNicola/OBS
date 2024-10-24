package com.obs.OBS.auth;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
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


  @NotBlank(message = "Email can't be empty")
  @Column(unique = true)
  private String email;

  @NotBlank(message = "Password can't be empty")
  private String password;

  private String confirmedPassword;

  private String role;
}
