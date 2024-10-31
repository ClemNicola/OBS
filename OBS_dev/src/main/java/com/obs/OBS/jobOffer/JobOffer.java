package com.obs.OBS.jobOffer;

import com.obs.OBS.company.Company;
import com.obs.OBS.jobSeeker.CONTRACT;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.Set;
import lombok.Data;

@Entity
@Data
@Table(name = "JOB_OFFER")
public class JobOffer {
  @Id
  @Column(name = "ID_JOB_OFFER")
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private String jobTitle;
  private String description;
  @ElementCollection
  @CollectionTable(name = "SKILLS", joinColumns = @JoinColumn(name = "ID_JOB_OFFER"))
  private Set<String> skills;
  private Date publicationDate;
  private String city;
  private String country;
  @Enumerated(value = EnumType.STRING)
  private MODE mode;
  @Enumerated(value = EnumType.STRING)
  private CONTRACT contract;
  private String contractDuration;
  private Integer minSalary;
  private Integer maxSalary;
  @Enumerated(value = EnumType.STRING)
  private EXPERIENCE experience;
  @Enumerated(value = EnumType.STRING)
  private STATUS status;
  @ElementCollection
  @CollectionTable(name = "TAGS", joinColumns = @JoinColumn(name = "ID_JOB_OFFER"))
  private Set<String> tags;
  private Integer numberOfApplicants;

  @ManyToOne
  @JoinColumn(name = "ID_USER", nullable = false)
  private Company company;
}
