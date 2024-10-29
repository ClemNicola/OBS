package com.obs.OBS.document;

import com.obs.OBS.jobSeeker.Seeker;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
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
  @Lob
  private byte[] data;
  @ManyToOne
  @JoinColumn(name = "ID_USER", referencedColumnName =  "ID_USER", nullable = false)
  private Seeker seeker;

}
