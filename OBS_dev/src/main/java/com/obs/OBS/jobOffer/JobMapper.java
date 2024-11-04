package com.obs.OBS.jobOffer;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class JobMapper {

  public JobDTO toDTO(JobOffer job){
    JobDTO dto = new JobDTO();
    dto.setCompanyId(job.getCompany().getId());
    dto.setJobTitle(job.getJobTitle());
    dto.setDescription(job.getDescription());
    dto.setSkills(job.getSkills());
    dto.setPublicationDate(job.getPublicationDate());
    dto.setCity(job.getCity());
    dto.setCountry(job.getCountry());
    dto.setMode(job.getMode());
    dto.setContract(job.getContract());
    dto.setContractDuration(job.getContractDuration());
    dto.setMinSalary(job.getMinSalary());
    dto.setMaxSalary(job.getMaxSalary());
    dto.setExperience(job.getExperience());
    dto.setStatus(job.getStatus());
    dto.setTags(job.getTags());
    dto.setNumberOfApplicants(job.getNumberOfApplicants());

    return dto;
  }

  public JobOffer toEntity(JobDTO dto){
    JobOffer jobOffer = new JobOffer();
   jobOffer.setJobTitle(dto.getJobTitle());
   jobOffer.setDescription(dto.getDescription());
   jobOffer.setSkills(dto.getSkills());
   jobOffer.setPublicationDate(dto.getPublicationDate());
   jobOffer.setCity(dto.getCity());
   jobOffer.setCountry(dto.getCountry());
   jobOffer.setMode(dto.getMode());
   jobOffer.setContract(dto.getContract());
   jobOffer.setContractDuration(dto.getContractDuration());
   jobOffer.setMinSalary(dto.getMinSalary());
   jobOffer.setMaxSalary(dto.getMaxSalary());
   jobOffer.setExperience(dto.getExperience());
   jobOffer.setStatus(dto.getStatus());
   jobOffer.setTags(dto.getTags());
   jobOffer.setNumberOfApplicants(dto.getNumberOfApplicants());

    return jobOffer;
  }

  public List<JobDTO> toDTOs (List<JobOffer> job){
    return job.stream().map(this::toDTO).collect(Collectors.toList());
  }
}
