package com.obs.OBS.elasticSearch.Repository;

import com.obs.OBS.elasticSearch.Document.CompanyDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDocRepository extends ElasticsearchRepository<CompanyDocument, String> {
}
