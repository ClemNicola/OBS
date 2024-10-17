package com.obs.OBS.jobSeeker;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SeekerServiceImpl implements SeekerService {
  private final SeekerDAO seekerDAO;
  private final SeekerMapper mapper;

  @Override
  public SeekerDTO getById(String id) {
    return mapper.toDto(seekerDAO.getById(id).orElseThrow(() -> new EntityNotFoundException("Can't find user with id " + id)));
  }

  @Override
  public SeekerDTO createSeeker(SeekerDTO dto) {
    if(seekerDAO.existsByEmail(dto.getEmail())){
      throw new IllegalArgumentException("A user already exists with this email");
    }

    Seeker seeker = mapper.toEntity(dto);
    Seeker savedSeeker = seekerDAO.create(seeker);
    mapper.toDto(savedSeeker);
    log.info("Seeker successfully created");

    return dto;
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
    }
  }

  @Override
  public List<SeekerDTO> getAll() {
    return mapper.toDtos(seekerDAO.getAll());
  }
}
