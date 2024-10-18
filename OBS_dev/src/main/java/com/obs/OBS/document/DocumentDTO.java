package com.obs.OBS.document;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class DocumentDTO {
  private String id;
  private String name;
  private String type;
  private long size;
  private byte[] data;
  private String seekerId;

  public DocumentDTO() {
  }

}
