package com.obs.OBS.jobOffer;

import com.obs.OBS.jobSeeker.CONTRACT;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import java.util.Date;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class JobDTO {
  private String companyId;
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

  public JobDTO() {
  }
}
