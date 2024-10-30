package com.obs.OBS.company;

import com.obs.OBS.jobOffer.JobOffer;
import com.obs.OBS.user.User;
import com.obs.OBS.user.UserType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Entity
@Data
@Table(name = "COMPANY")
public class Company extends User {
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
  @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  private List<JobOffer> jobOffers = new ArrayList<>();


  public Company(){super.setType(UserType.COMPANY);}

  public Company(String adminName, String email, String password, String name, SECTORS sectors,
      COMPANYTYPE companyType, String companyEmail, String siret, String webUrl, String address, String city,
      String country, String zip) {
    super(email, password);
    this.adminName = adminName;
    this.name = name;
    this.sectors = sectors;
    this.companyType = companyType;
    this.companyEmail = companyEmail;
    this.siret = siret;
    this.webUrl = webUrl;
    this.address = address;
    this.city = city;
    this.country = country;
    this.zip = zip;
    super.setType(UserType.COMPANY);

  }
}
