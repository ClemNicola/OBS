package com.obs.OBS.jobOffer;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JobService {
  JobDTO getJobById(String id);
  JobDTO createJobOffer(JobDTO dto);
  Page<JobDTO> getAllJobsByCompanyId(String companyId, Pageable pageable);
  Page<JobDTO> getAllJobs(Pageable pageable);
  void deleteJobOffer(String id);
  JobDTO updateJobOffer(String id, JobDTO dto);
  Page<JobDTO> getJobByTags(List<String> tag, Pageable pageable);
  Page<JobDTO> getJobBySkills(String skills, Pageable pageable);
  Page<JobDTO> getJobByTitle(String jobTitle, Pageable pageable);

}
