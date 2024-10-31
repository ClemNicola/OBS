package com.obs.OBS.jobOffer;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface JobDAO {
  Optional<JobOffer> getJobById(String id);
  Page<JobOffer> getJobByTags(List<String> tag, Pageable pageable);
  Page<JobOffer> getAllJobsByCompanyId(String companyId, Pageable pageable);
  Page<JobOffer> getJobBySkills(String skills, Pageable pageable);
  Page<JobOffer> getJobByTitle(String jobTitle, Pageable pageable);
  JobOffer create(JobOffer job);
  JobOffer update(String id, JobOffer job);
  void delete(String id);
}
