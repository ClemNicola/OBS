package com.obs.OBS.jobSeeker;

import java.util.List;

public interface SeekerService {
  SeekerDTO getById(String Id);
  SeekerDTO createSeeker(SeekerDTO dto);
  SeekerDTO updateSeeker(String id, SeekerDTO dto);
  void deleteSeeker (String id);
  List<SeekerDTO> getAll();
}
