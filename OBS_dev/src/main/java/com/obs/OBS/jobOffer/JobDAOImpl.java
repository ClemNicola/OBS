package com.obs.OBS.jobOffer;

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

  @Override
  public Optional<JobOffer> getJobById(String id) {
    return repository.findById(id);
  }

  @Override
  public Page<JobOffer> getJobByTags(List<String> tag, Pageable pageable) {
    return repository.findJobOfferByTagsIn(tag,pageable);
  }

  @Override
  public Page<JobOffer> getAllJobsByCompanyId(String companyId, Pageable pageable) {
    return repository.findJobOfferByCompanyId(companyId, pageable);
  }

  @Override
  public Page<JobOffer> getJobBySkills(String skills, Pageable pageable) {
    return repository.findJobOfferBySkillsContains(skills, pageable);
  }

  @Override
  public Page<JobOffer> getJobByTitle(String jobTitle, Pageable pageable) {
    return repository.findJobOfferByJobTitle(jobTitle, pageable);
  }

  @Override
  public Page<JobOffer> getAllJobs(Pageable pageable) {
    return repository.findAllJobOffer(pageable);
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
