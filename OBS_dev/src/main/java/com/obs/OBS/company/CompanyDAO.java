package com.obs.OBS.company;

import com.obs.OBS.elasticSearch.Document.CompanyDocument;
import java.util.List;
import java.util.Optional;

public interface CompanyDAO {
  Optional<Company> getById(String id);
  List<Company> getAll();
  boolean existsByEmail(String email);
  Company create(Company company);
  Company update(String id, Company company);
  void delete(String id);
  boolean existsById(String id);

  void deleteAll();
  void saveAll(List<CompanyDocument> companyDocuments);

}
