package com.obs.OBS.jobSeeker;

import com.obs.OBS.elasticSearch.Document.SeekerDocument;
import java.util.List;
import java.util.Optional;

public interface SeekerDAO {
  Optional<Seeker> getById(String id);
  List<Seeker> getAll();
  boolean seekerIsExisting(String id);
  boolean existsByEmail(String email);
  Seeker create(Seeker seeker);
  Seeker update(String id, Seeker seeker);
  void delete(String id);
  void deleteAll();
  void saveAll(List<SeekerDocument> seekerDocuments);
}
