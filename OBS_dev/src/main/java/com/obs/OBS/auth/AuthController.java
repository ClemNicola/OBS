package com.obs.OBS.auth;

import com.obs.OBS.company.CompanyDTO;
import com.obs.OBS.company.CompanyService;
import com.obs.OBS.jobSeeker.SeekerDTO;
import com.obs.OBS.jobSeeker.SeekerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
  private final SeekerService service;
  private final CompanyService companyService;

  @PostMapping("/login")
  public ResponseEntity<AuthResponse> authenticate(@RequestBody LoginRequest loginRequest){
    AuthResponse response = service.loginSeeker(loginRequest);
    return ResponseEntity.ok(response);
  }

  @PostMapping("/signup")
  public ResponseEntity<SeekerDTO> signup(@RequestBody SignupRequest signupRequest){
    SeekerDTO dto = service.createSeeker(signupRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(dto);
  }

  @PostMapping("/login/company")
  public ResponseEntity<AuthResponse> authenticateCompany(@RequestBody LoginRequest loginRequest){
    AuthResponse response = companyService.loginCompany(loginRequest);
    return ResponseEntity.ok(response);
  }

  @PostMapping("/signup/company")
  public ResponseEntity<CompanyDTO> signupCompany(@RequestBody CompanySignupRequest signupRequest){
    CompanyDTO dto = companyService.createCompany(signupRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(dto);
  }



}
