package com.obs.OBS.jobSeeker;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeekerRepository extends CrudRepository<Seeker, String> {
  boolean existsByEmail(String email);
}
