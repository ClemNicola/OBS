package com.obs.OBS.jobSeeker;

import java.util.Optional;

public interface SeekerDAO {
  Optional<Seeker> getById(String id);
  boolean seekerIsExisting(String id);
  boolean existsByEmail(String email);
  Seeker create(Seeker seeker);
  Seeker update(String id, Seeker seeker);
  void delete(String id);
}
