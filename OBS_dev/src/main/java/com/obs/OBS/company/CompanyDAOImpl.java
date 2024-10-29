package com.obs.OBS.company;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompanyDAOImpl implements CompanyDAO{
 private final CompanyRepository repository;

  @Override
  public Optional<Company> getById(String id) {
    return repository.findById(id);
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
}
