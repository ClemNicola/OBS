package com.obs.OBS.jobSeeker;

import com.obs.OBS.auth.AuthResponse;
import com.obs.OBS.auth.LoginRequest;
import com.obs.OBS.auth.SignupRequest;
import java.util.List;

public interface SeekerService {
  SeekerDTO getById(String Id);
  SeekerDTO createSeeker(SignupRequest request);
  SeekerDTO updateSeeker(String id, SeekerDTO dto);
  void deleteSeeker (String id);
  List<SeekerDTO> getAll();
  AuthResponse loginSeeker(LoginRequest loginRequest);
}
