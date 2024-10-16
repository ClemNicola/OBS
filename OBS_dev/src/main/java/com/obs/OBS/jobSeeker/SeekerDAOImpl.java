package com.obs.OBS.jobSeeker;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
public class SeekerDAOImpl implements SeekerDAO {

  private final SeekerRepository seekerRepository;
  protected SeekerDAOImpl(SeekerRepository seekerRepository){
    this.seekerRepository = seekerRepository;
  }

  @Override
  public Optional<Seeker> getById(String id){
   return seekerRepository.findById(id);
  }

  @Override
  public boolean seekerIsExisting(String id){
    return seekerRepository.existsById(id);
  }

  @Override
  public boolean existsByEmail(String email){
    return seekerRepository.existsByEmail(email);
  }

  public Seeker create(Seeker entity){
    return seekerRepository.save(entity);
  }

  public Seeker update(String id, Seeker entity){
    return seekerRepository.save(entity);
  }

  public void delete(String id){
    seekerRepository.deleteById(id);
  }
}
