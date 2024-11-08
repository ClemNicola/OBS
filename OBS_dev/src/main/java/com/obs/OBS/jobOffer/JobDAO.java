package com.obs.OBS.jobOffer;

import com.obs.OBS.elasticSearch.Document.JobOfferDocument;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface JobDAO {
  Optional<JobOffer> getJobById(String id);
  Page<JobOffer> getAllJobsByCompanyId(String companyId, Pageable pageable);
  Page<JobOfferDocument> getJobBySkills(String skills, Pageable pageable);
  Page<JobOfferDocument> getJobByTitle(String jobTitle, Pageable pageable);
  Page<JobOfferDocument> getJobByCity(String city, Pageable pageable);
  Page<JobOfferDocument> getJobByCompanyName(String companyName, Pageable pageable);
  Page<JobOffer> getAllJobs(Pageable pageable);
  JobOffer create(JobOffer job);
  JobOffer update(String id, JobOffer job);
  void delete(String id);
  boolean existingJobOffer(String id);
  void deleteAll();
  void saveAll(List<JobOfferDocument> jobOfferDocuments);
  List<JobOffer> getAll();
}
