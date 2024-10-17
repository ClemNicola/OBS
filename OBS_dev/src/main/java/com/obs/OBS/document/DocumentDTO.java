package com.obs.OBS.document;


import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class DocumentDTO {
  private String id;
  private String name;
  private String type;
  private long size;
  private byte[] data;
  private String seekerId;

  public DocumentDTO() {
  }

  public DocumentDTO(String id, String name, String type, long size, byte[] data, String seekerId) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.size = size;
    this.data = data;
    this.seekerId = seekerId;
  }
}
