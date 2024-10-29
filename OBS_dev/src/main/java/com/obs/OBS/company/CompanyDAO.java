package com.obs.OBS.company;

import java.util.Optional;

public interface CompanyDAO {
  Optional<Company> getById(String id);
  boolean existsByEmail(String email);
  Company create(Company company);
  Company update(String id, Company company);
  void delete(String id);
  boolean existsById(String id);

}
