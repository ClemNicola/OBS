package com.obs.OBS.auth;

import com.obs.OBS.company.COMPANYTYPE;
import com.obs.OBS.company.SECTORS;
import com.obs.OBS.user.UserType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class CompanySignupRequest {
  @NotBlank(message = "Admin name can't be empty")
  private String adminName;

  @NotBlank(message = "Email can't be empty")
  @Column(unique = true)
  private String email;

  @NotBlank(message = "Password can't be empty")
  private String password;

  private String confirmedPassword;

  private UserType role;
  private String name;
  private String description;
  @Enumerated(value = EnumType.STRING)
  private SECTORS sectors;
  @Enumerated(value = EnumType.STRING)
  private COMPANYTYPE companyType;
  private String address;
  private String city;
  private String country;
  private String zip;
  private String webUrl;
  private String companyEmail;
  private String siret;


}
