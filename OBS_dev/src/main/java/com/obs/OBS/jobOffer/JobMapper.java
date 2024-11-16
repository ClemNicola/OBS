package com.obs.OBS.jobOffer;

import com.obs.OBS.elasticSearch.Document.JobOfferDocument;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class JobMapper {

  public JobDTO toDTO(JobOffer job){
    JobDTO dto = new JobDTO();
    dto.setId(job.getId());
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

  public JobDTO DocumentToDTO(JobOfferDocument document){
    JobDTO dto = new JobDTO();
    dto.setId(document.getId());
    dto.setCompanyName(document.getCompanyName());
    dto.setCompanyId(document.getCompany().getId());
    dto.setJobTitle(document.getJobTitle());
    dto.setDescription(document.getDescription());
    dto.setSkills(document.getSkills());
    dto.setPublicationDate(document.getPublicationDate());
    dto.setCity(document.getCity());
    dto.setCountry(document.getCountry());
    dto.setMode(document.getMode());
    dto.setContract(document.getContract());
    dto.setContractDuration(document.getContractDuration());
    dto.setMinSalary(document.getMinSalary());
    dto.setMaxSalary(document.getMaxSalary());
    dto.setExperience(document.getExperience());
    dto.setStatus(document.getStatus());
    dto.setTags(document.getTags());
    dto.setNumberOfApplicants(document.getNumberOfApplicants());

    return dto;
  }

  public JobOfferDocument toDocument(JobOffer jobOffer){
    JobOfferDocument jobOfferDocument = new JobOfferDocument();
    jobOfferDocument.setId(jobOffer.getId());
    jobOfferDocument.setCompanyName(jobOffer.getCompany().getName());
    jobOfferDocument.setJobTitle(jobOffer.getJobTitle());
    jobOfferDocument.setDescription(jobOffer.getDescription());
    jobOfferDocument.setSkills(jobOffer.getSkills());
    jobOfferDocument.setPublicationDate(jobOffer.getPublicationDate());
    jobOfferDocument.setCity(jobOffer.getCity());
    jobOfferDocument.setCountry(jobOffer.getCountry());
    jobOfferDocument.setMode(jobOffer.getMode());
    jobOfferDocument.setContract(jobOffer.getContract());
    jobOfferDocument.setContractDuration(jobOffer.getContractDuration());
    jobOfferDocument.setMinSalary(jobOffer.getMinSalary());
    jobOfferDocument.setMaxSalary(jobOffer.getMaxSalary());
    jobOfferDocument.setExperience(jobOffer.getExperience());
    jobOfferDocument.setStatus(jobOffer.getStatus());
    jobOfferDocument.setTags(jobOffer.getTags());
    jobOfferDocument.setNumberOfApplicants(jobOffer.getNumberOfApplicants());

    return jobOfferDocument;
  }

}
