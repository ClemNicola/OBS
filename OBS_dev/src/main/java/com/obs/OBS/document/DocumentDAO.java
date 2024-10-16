package com.obs.OBS.document;

import java.util.List;
import java.util.Optional;
import lombok.Builder;
import lombok.Data;


public interface DocumentDAO {
  Optional<Document> getById(String id);
  Document create(Document document);
  void delete(String id);
  boolean isExistingById(String id);
  List<Document> getAll();
}
