package com.obs.OBS.company;

import com.obs.OBS.user.UserType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class CompanyDTO {
  private String id;
  private String email;
  private String password;
  @Enumerated(EnumType.STRING)
  private UserType userType;
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
  private String adminName;

  public CompanyDTO() {
  }
}
