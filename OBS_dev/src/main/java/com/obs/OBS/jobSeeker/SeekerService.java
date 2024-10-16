package com.obs.OBS.jobSeeker;

public interface SeekerService {

  SeekerDTO getById(String Id);
 SeekerDTO createSeeker(SeekerDTO dto);
 SeekerDTO updateSeeker(String id, SeekerDTO dto);
 void deleteSeeker (String id);
}
