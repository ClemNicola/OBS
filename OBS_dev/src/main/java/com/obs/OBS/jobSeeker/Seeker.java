package com.obs.OBS.jobSeeker;

import com.obs.OBS.document.Document;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lombok.Data;

@Entity
@Table(name = "JOB_SEEKER")
@Data
public class Seeker {
  @Id
  @Column(name = "ID_SEEKER")
  private String id;

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

  @OneToMany(mappedBy = "seeker", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Document> documents = new ArrayList<>();


}
