package com.obs.OBS.company;

import com.obs.OBS.auth.AuthResponse;
import com.obs.OBS.auth.CompanySignupRequest;
import com.obs.OBS.auth.JWTUtil;
import com.obs.OBS.auth.LoginRequest;
import com.obs.OBS.user.User;
import com.obs.OBS.user.UserDAO;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyServiceImpl implements CompanyService {
  private final CompanyDAO dao;
  private final UserDAO userDAO;
  private final CompanyMapper mapper;
  private final JWTUtil util;
  private final AuthenticationManager manager;
  private final PasswordEncoder encoder;
  @Override
  public CompanyDTO getById(String id) {
    Company existingCompany = dao.getById(id).orElseThrow(() -> new EntityNotFoundException("Can't find company with id: " + id));
    return mapper.toDTO(existingCompany);
  }

  @Override
  public void deleteById(String id) {
    if(dao.existsById(id)){
      dao.delete(id);
    }else{
      throw new RuntimeException("Can't find company with id: " + id);
    }
  }

  @Override
  public CompanyDTO updateCompany(String id, CompanyDTO dto) {
    Company currentCompany = dao.getById(id).orElseThrow(() -> new EntityNotFoundException("Can't find user with id " + id));

    currentCompany.setAdminName(dto.getAdminName());
    currentCompany.setEmail(dto.getEmail());
    currentCompany.setName(dto.getName());
    currentCompany.setDescription(dto.getDescription());
    currentCompany.setCompanyEmail(dto.getCompanyEmail());
    currentCompany.setSectors(dto.getSectors());
    currentCompany.setCompanyType(dto.getCompanyType());
    currentCompany.setWebUrl(dto.getWebUrl());
    currentCompany.setAddress(dto.getAddress());
    currentCompany.setCity(dto.getCity());
    currentCompany.setCountry(dto.getCountry());
    currentCompany.setZip(dto.getZip());

    Company updatedCompany = dao.update(id, currentCompany);
    log.info("Company successfully updated");
    return mapper.toDTO(updatedCompany);

  }

  @Override
  public CompanyDTO createCompany(CompanySignupRequest signupRequest) {
    if(dao.existsByEmail(signupRequest.getEmail())){
      throw new IllegalArgumentException("A user already exists with this email");
    }

    if(!signupRequest.getConfirmedPassword().equals(signupRequest.getPassword())){
      throw new IllegalArgumentException("Passwords do not match");
    }

    Company company = new Company(
        signupRequest.getAdminName(),
        signupRequest.getEmail(),
        encoder.encode(signupRequest.getPassword()),
        signupRequest.getName(),
        signupRequest.getSectors(),
        signupRequest.getCompanyType(),
        signupRequest.getCompanyEmail(),
        signupRequest.getSiret(),
        signupRequest.getWebUrl(),
        signupRequest.getAddress(),
        signupRequest.getCity(),
        signupRequest.getCountry(),
        signupRequest.getZip()
    );

    Company savedCompany = dao.create(company);
    return mapper.toDTO(savedCompany);
  }

  @Override
  public AuthResponse loginCompany(LoginRequest request) {
    Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(
        request.getEmail(), request.getPassword())
    );
    SecurityContextHolder.getContext().setAuthentication(authentication);

    User existingUser = userDAO.findByEmail(request.getEmail()).orElseThrow(()
        -> new EntityNotFoundException("Can't find user with id: " + request.getEmail()));

    String jwt = util.generateToken(existingUser);

    return new AuthResponse(jwt, existingUser.getType());
  }
}
