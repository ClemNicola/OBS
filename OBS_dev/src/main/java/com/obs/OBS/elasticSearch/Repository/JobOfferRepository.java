package com.obs.OBS.elasticSearch.Repository;

import com.obs.OBS.elasticSearch.Document.JobOfferDocument;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobOfferRepository extends ElasticsearchRepository<JobOfferDocument, String> {
    Page<JobOfferDocument> findJobOfferDocumentBySkillsContaining(String skills, Pageable pageable);
    Page<JobOfferDocument> findJobOfferDocumentByCityContaining(String city, Pageable pageable);
    Page<JobOfferDocument> findJobOfferDocumentByJobTitleContaining(String jobTitle, Pageable pageable);
    Page<JobOfferDocument> findJobOfferDocumentByTagsIn(List<String> tags, Pageable pageable);
}
