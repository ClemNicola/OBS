package com.obs.OBS.document;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends CrudRepository<Document, String> {
  List<Document> findBySeekerId(String seekerId);
}
