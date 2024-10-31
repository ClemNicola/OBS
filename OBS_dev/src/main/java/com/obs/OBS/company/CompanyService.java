package com.obs.OBS.company;

import com.obs.OBS.auth.AuthResponse;
import com.obs.OBS.auth.CompanySignupRequest;
import com.obs.OBS.auth.LoginRequest;

public interface CompanyService {
  CompanyDTO getById(String id);
  void deleteById(String id);
  CompanyDTO updateCompany(String id, CompanyDTO dto);
  CompanyDTO createCompany(CompanySignupRequest signupRequest);
  AuthResponse loginCompany(LoginRequest request);
}
