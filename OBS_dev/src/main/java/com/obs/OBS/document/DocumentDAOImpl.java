package com.obs.OBS.document;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class DocumentDAOImpl implements DocumentDAO {
  private final DocumentRepository repository;
  protected DocumentDAOImpl(DocumentRepository repository){
    this.repository = repository;
  }
  @Override
  public Optional<Document> getById(String id) {
    return repository.findById(id);
  }

  @Override
  public Document create(Document document) {
    return repository.save(document);
  }

  @Override
  public void delete(String id) {
    repository.deleteById(id);
  }

  @Override
  public boolean isExistingById(String id) {
    return repository.existsById(id);
  }

  @Override
  public List<Document> getAllBySeekerId(String seekerId) {
    return repository.findBySeekerId(seekerId);
  }
}
