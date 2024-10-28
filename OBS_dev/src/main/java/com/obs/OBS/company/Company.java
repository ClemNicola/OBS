package com.obs.OBS.company;

import com.obs.OBS.jobOffer.JobOffer;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Entity
@Data
@Table(name = "COMPANY")
public class Company {
  @Id
  private String name;
  private String description;
  @Enumerated(value = EnumType.STRING)
  private SECTORS sectors;
  @Enumerated(value = EnumType.STRING)
  private COMPANYTYPE type;
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
}
