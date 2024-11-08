package com.obs.OBS.jobOffer;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JobService {
  JobDTO getJobById(String id);
  JobDTO createJobOffer(JobDTO dto);
  Page<JobDTO> getAllJobsByCompanyId(String companyId, Pageable pageable);
  Page<JobDTO> getAllJobs(Pageable pageable);
  void deleteJobOffer(String id);
  JobDTO updateJobOffer(String id, JobDTO dto);
  Page<JobDTO> searchJobBySkills(String skills, Pageable pageable);
  Page<JobDTO> searchJobByCompanyName(String companyName, Pageable pageable);
  Page<JobDTO> searchJobByTitle(String jobTitle, Pageable pageable);
  Page<JobDTO> searchJobByCity(String city, Pageable pageable);

}
