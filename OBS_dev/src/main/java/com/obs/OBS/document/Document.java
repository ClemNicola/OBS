package com.obs.OBS.document;

import com.obs.OBS.jobSeeker.Seeker;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "DOCUMENT")
@Data
public class Document {

  @Id
  @Column(name = "ID_DOCUMENT")
  private String id;
  private String name;
  private String type;
  private long size;
  private byte[] data;
  @ManyToOne
  @JoinColumn(name = "ID_SEEKER", nullable = false)
  private Seeker seeker;

}
