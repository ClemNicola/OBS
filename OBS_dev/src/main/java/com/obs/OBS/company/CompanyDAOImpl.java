package com.obs.OBS.company;

import com.obs.OBS.elasticSearch.Document.CompanyDocument;
import com.obs.OBS.elasticSearch.Repository.CompanyDocRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompanyDAOImpl implements CompanyDAO{
 private final CompanyRepository repository;
 private final CompanyDocRepository docRepository;

  @Override
  public Optional<Company> getById(String id) {
    return repository.findById(id);
  }

  @Override
  public List<Company> getAll() {
    return (List<Company>) repository.findAll();
  }

  @Override
  public boolean existsByEmail(String email) {
    return repository.existsByEmail(email);
  }

  @Override
  public Company create(Company company) {
    return repository.save(company);
  }

  @Override
  public Company update(String id, Company company) {
    return repository.save(company);
  }

  @Override
  public void delete(String id) {
    repository.deleteById(id);
  }

  @Override
  public boolean existsById(String id) {
    return repository.existsById(id);
  }

  @Override
  public void deleteAll() {
    docRepository.deleteAll();
  }

  @Override
  public void saveAll(List<CompanyDocument> companyDocuments) {
      docRepository.saveAll(companyDocuments);
  }
}
