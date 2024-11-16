package com.obs.OBS.elasticSearch.Repository;

import com.obs.OBS.elasticSearch.Document.SeekerDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeekerDocRepository extends ElasticsearchRepository<SeekerDocument, String> {
}
