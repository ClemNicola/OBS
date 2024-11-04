package com.obs.OBS.jobOffer;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService{
  @Override
  public JobDTO getJobById(String id) {
    return null;
  }

  @Override
  public JobDTO createJobOffer(JobDTO dto) {
    return null;
  }

  @Override
  public Page<JobDTO> getAllJobsByCompanyId(String companyId, Pageable pageable) {
    return null;
  }

  @Override
  public void deleteJobOffer(String id) {

  }

  @Override
  public JobDTO updateJobOffer(String id, JobDTO dto) {
    return null;
  }

  @Override
  public Page<JobDTO> getJobByTags(List<String> tag, Pageable pageable) {
    return null;
  }

  @Override
  public Page<JobDTO> getJobBySkills(String skills, Pageable pageable) {
    return null;
  }

  @Override
  public Page<JobDTO> getJobByTitle(String jobTitle, Pageable pageable) {
    return null;
  }
}
