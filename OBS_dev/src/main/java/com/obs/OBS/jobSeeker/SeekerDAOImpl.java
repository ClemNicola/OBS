package com.obs.OBS.jobSeeker;

import com.obs.OBS.user.UserType;
import java.util.List;
import java.util.Optional;
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
  public List<Seeker> getAll() {
    return seekerRepository.findByType(UserType.SEEKER);
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
