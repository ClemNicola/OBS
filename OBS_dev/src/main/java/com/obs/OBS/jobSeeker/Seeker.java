package com.obs.OBS.jobSeeker;

import com.obs.OBS.document.Document;
import com.obs.OBS.user.User;
import com.obs.OBS.user.UserType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Seeker extends User {

  private String firstName;
  private String lastName;
  private String phoneNumber;
  @ElementCollection
  @Enumerated(EnumType.STRING)
  private Set<CONTRACT> contractType;
  @ElementCollection
  @CollectionTable(name = "SEEKER_LOCATIONS", joinColumns = @JoinColumn(name = "ID_USER"))
  private Set<String> desiredLocations;
  private String description;

  @OneToMany(mappedBy = "seeker", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Document> documents = new ArrayList<>();

  public Seeker(){
    super.setType(UserType.SEEKER);
  }

  public Seeker(String firstName, String lastName, String email, String password){
    super(email, password);
    this.firstName = firstName;
    this.lastName = lastName;
  }

}
