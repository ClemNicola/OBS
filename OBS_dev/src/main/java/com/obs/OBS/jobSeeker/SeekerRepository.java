package com.obs.OBS.jobSeeker;

import com.obs.OBS.user.UserType;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeekerRepository extends CrudRepository<Seeker, String> {
  boolean existsByEmail(String email);
  List<Seeker> findByType(UserType type);
}
