package com.obs.OBS.jobOffer;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends CrudRepository<JobOffer, String> {
  Page<JobOffer> findJobOfferByTagsIn(List<String> tag, Pageable pageable);
  Page<JobOffer> findJobOfferByJobTitle(String title, Pageable pageable);
  Page<JobOffer> findJobOfferByCompanyId(String id, Pageable pageable);
  Page<JobOffer> findJobOfferBySkillsContains(String skill, Pageable pageable);
  Page<JobOffer> findAllJobOffer(Pageable pageable);
}
