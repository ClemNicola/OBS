package com.obs.OBS.jobSeeker;

import com.obs.OBS.auth.AuthResponse;
import com.obs.OBS.auth.JWTUtil;
import com.obs.OBS.auth.LoginRequest;
import com.obs.OBS.auth.SignupRequest;
import com.obs.OBS.user.User;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SeekerServiceImpl implements SeekerService {
  private final SeekerDAO seekerDAO;
  private final SeekerMapper mapper;
  private final JWTUtil util;
  private AuthenticationManager authenticationManager;
  private PasswordEncoder encoder;

  @Override
  public SeekerDTO getById(String id) {
    return mapper.toDto(seekerDAO.getById(id).orElseThrow(() -> new EntityNotFoundException("Can't find user with id " + id)));
  }

  @Override
  public SeekerDTO createSeeker(SignupRequest request) {
    if(seekerDAO.existsByEmail(request.getEmail())){
      throw new IllegalArgumentException("A user already exists with this email");
    }

    if(!request.getConfirmedPassword().equals(request.getPassword())){
      throw new IllegalArgumentException("Password do not match");
    }

    Seeker seeker = new Seeker(
      request.getFirstName(),
      request.getLastName(),
      request.getEmail(),
      encoder.encode(request.getPassword())
    );

    Seeker savedSeeker = seekerDAO.create(seeker);
    log.info("Seeker successfully created");

    return mapper.toDto(savedSeeker);
  }

  @Override
  public SeekerDTO updateSeeker(String id, SeekerDTO dto) {
    Seeker currentSeeker = seekerDAO.getById(id).orElseThrow(() -> new EntityNotFoundException("Can't find user with id " + id));

    currentSeeker.setFirstName(dto.getFirstName());
    currentSeeker.setLastName(dto.getLastName());
    currentSeeker.setPhoneNumber(dto.getPhoneNumber());
    currentSeeker.setEmail(dto.getEmail());
    currentSeeker.setContractType(dto.getContractType());
    currentSeeker.setDescription(dto.getDescription());
    currentSeeker.setDesiredLocations(dto.getDesiredLocations());

    seekerDAO.update(id, currentSeeker);
    log.info("Seeker successfully updated");

    return dto;
  }

  @Override
  public void deleteSeeker(String id) {
    if(seekerDAO.seekerIsExisting(id)){
      seekerDAO.delete(id);
      log.info("Seeker successfully deleted");
    }else{
      throw new RuntimeException("Can't delete seeker with id: " + id);
    }
  }

  @Override
  public List<SeekerDTO> getAll() {
    return mapper.toDtos(seekerDAO.getAll());
  }

  @Override
  public AuthResponse loginSeeker(LoginRequest loginRequest) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);

    User existingUser = seekerDAO.getByEmail(loginRequest.getEmail()).orElseThrow(()
        -> new EntityNotFoundException("Can'find user with email: " + loginRequest.getEmail()));

    String jwt = util.generateToken(existingUser);


    return new AuthResponse(jwt);
  }

}
