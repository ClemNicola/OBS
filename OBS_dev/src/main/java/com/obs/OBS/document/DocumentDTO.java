package com.obs.OBS.document;

import com.obs.OBS.jobSeeker.SeekerDTO;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@Data
@RequiredArgsConstructor
public class DocumentDTO {
  private String id;
  private String name;
  private String type;
  private byte[] data;
  private String seekerId;
}
