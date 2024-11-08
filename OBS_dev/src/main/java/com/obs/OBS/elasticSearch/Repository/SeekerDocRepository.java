package com.obs.OBS.elasticSearch.Repository;

import com.obs.OBS.elasticSearch.Document.SeekerDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SeekerDocRepository extends ElasticsearchRepository<SeekerDocument, String> {
}
