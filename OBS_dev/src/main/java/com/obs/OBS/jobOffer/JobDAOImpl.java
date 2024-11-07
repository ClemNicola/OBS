package com.obs.OBS.jobOffer;

import com.obs.OBS.elasticSearch.Document.JobOfferDocument;
import com.obs.OBS.elasticSearch.Repository.JobOfferRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JobDAOImpl implements JobDAO{
  private final JobRepository repository;
  private final JobOfferRepository jobOfferDocRepository;

  @Override
  public Optional<JobOffer> getJobById(String id) {
    return repository.findById(id);
  }

  @Override
  public Page<JobOfferDocument> getJobByTags(List<String> tag, Pageable pageable) {
    return jobOfferDocRepository.findJobOfferDocumentByTagsIn(tag, pageable);
  }

  @Override
  public Page<JobOffer> getAllJobsByCompanyId(String companyId, Pageable pageable) {
    return repository.findJobOfferByCompanyId(companyId, pageable);
  }

  @Override
  public Page<JobOfferDocument> getJobBySkills(String skills, Pageable pageable) {
    return jobOfferDocRepository.findJobOfferDocumentBySkillsContaining(skills, pageable);
  }

  @Override
  public Page<JobOfferDocument> getJobByTitle(String jobTitle, Pageable pageable) {
    return jobOfferDocRepository.findJobOfferDocumentByJobTitleContaining(jobTitle, pageable);
  }

  @Override
  public Page<JobOfferDocument> getJobByCity(String city, Pageable pageable) {
    return jobOfferDocRepository.findJobOfferDocumentByCityContaining(city, pageable);
  }

  @Override
  public Page<JobOffer> getAllJobs(Pageable pageable) {
    return repository.findAll(pageable);
  }

  @Override
  public JobOffer create(JobOffer job) {
    return repository.save(job);
  }

  @Override
  public JobOffer update(String id, JobOffer job) {
    return repository.save(job);
  }

  @Override
  public void delete(String id) {
    repository.deleteById(id);
  }

  @Override
  public boolean existingJobOffer(String id) {
    return repository.existsById(id);
  }
}
