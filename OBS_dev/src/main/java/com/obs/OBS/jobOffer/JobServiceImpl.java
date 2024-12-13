package com.obs.OBS.jobOffer;

import com.obs.OBS.company.Company;
import com.obs.OBS.company.CompanyDAO;
import com.obs.OBS.elasticSearch.Document.JobOfferDocument;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class JobServiceImpl implements JobService{
  private final JobDAO dao;
  private final JobMapper mapper;
  private final CompanyDAO companyDAO;

  @Override
  public JobDTO getJobById(String id) {
    JobOffer jobOffer = dao.getJobById(id).orElseThrow(() -> new EntityNotFoundException("Can't find job with id: " + id));
    return mapper.toDTO(jobOffer);
  }

  @Override
  @PreAuthorize("hasAuthority('COMPANY')")
  public JobDTO createJobOffer(String companyId, JobDTO dto){

    Company company = companyDAO.getById(companyId)
        .orElseThrow(() -> new EntityNotFoundException("Company not found with ID: " + companyId));

    JobOffer job = new JobOffer();
    job.setJobTitle(dto.getJobTitle());
    job.setDescription(dto.getDescription());
    job.setSkills(dto.getSkills());
    job.setPublicationDate(dto.getPublicationDate());
    job.setCity(dto.getCity());
    job.setCountry(dto.getCountry());
    job.setMode(dto.getMode());
    job.setContract(dto.getContract());
    job.setContractDuration(dto.getContractDuration());
    job.setMinSalary(dto.getMinSalary());
    job.setMaxSalary(dto.getMaxSalary());
    job.setExperience(dto.getExperience());
    job.setStatus(dto.getStatus() != null ? dto.getStatus() : STATUS.OPEN);
    job.setTags(dto.getTags());
    job.setNumberOfApplicants(dto.getNumberOfApplicants());
    job.setCompany(company);

    JobOffer savedJob = dao.create(job);
    log.info("Job successfully created");
    return mapper.toDTO(savedJob);
  }

  @Override
  @PreAuthorize("hasAuthority('COMPANY')")
  public JobDTO updateJobOffer(String id, JobDTO dto) {

    JobOffer currentJobOffer = dao.getJobById(id).orElseThrow(() -> new EntityNotFoundException("Can't find job with id: " + id));
    currentJobOffer.setJobTitle(dto.getJobTitle());
    currentJobOffer.setDescription(dto.getDescription());
    currentJobOffer.setSkills(dto.getSkills());
    currentJobOffer.setPublicationDate(dto.getPublicationDate());
    currentJobOffer.setCity(dto.getCity());
    currentJobOffer.setCountry(dto.getCountry());
    currentJobOffer.setMode(dto.getMode());
    currentJobOffer.setContract(dto.getContract());
    currentJobOffer.setContractDuration(dto.getContractDuration());
    currentJobOffer.setMinSalary(dto.getMinSalary());
    currentJobOffer.setMaxSalary(dto.getMaxSalary());
    currentJobOffer.setExperience(dto.getExperience());
    currentJobOffer.setStatus(dto.getStatus());
    currentJobOffer.setStatus(dto.getStatus());
    currentJobOffer.setNumberOfApplicants(dto.getNumberOfApplicants());

    JobOffer updatedJobOffer = dao.update(id, currentJobOffer);
    log.info("Job offer updated successfully");
    return mapper.toDTO(updatedJobOffer);
  }

  @Override
  @PreAuthorize("hasAuthority('COMPANY')")
  public void deleteJobOffer(String id) {
    dao.delete(id);
  }

  @Override
  public Page<JobDTO> getAllJobsByCompanyId(String companyId, Pageable pageable) {
    Company company = companyDAO.getById(companyId).orElseThrow(() -> new EntityNotFoundException("Can't find job with id: " + companyId));
    Page<JobOffer> jobOffers = dao.getAllJobsByCompanyId(company.getId(), pageable);
    return jobOffers.map(mapper::toDTO);
  }

  @Override
  public Page<JobDTO> getAllJobs(Pageable pageable) {
     Page<JobOffer> jobOfferPage = dao.getAllJobs(pageable);
     return jobOfferPage.map(mapper::toDTO);
  }

  @Override
  public Page<JobDTO> searchJobBySkills(String skills, Pageable pageable) {
    Page<JobOfferDocument> jobOfferPage = dao.getJobBySkills(skills, pageable);
    return jobOfferPage.map(mapper::DocumentToDTO);
  }

  @Override
  public Page<JobDTO> searchJobByCompanyName(String companyName, Pageable pageable) {
    Page<JobOfferDocument> jobOfferDocuments = dao.getJobByCompanyName(companyName, pageable);
    return jobOfferDocuments.map(mapper::DocumentToDTO);
  }

  @Override
  public Page<JobDTO> searchJobByTitle(String jobTitle, Pageable pageable) {
    Page<JobOfferDocument> jobOfferPage = dao.getJobByTitle(jobTitle, pageable);
    return jobOfferPage.map(mapper::DocumentToDTO);
  }

  @Override
  public Page<JobDTO> searchJobByCity(String city, Pageable pageable) {
    Page<JobOfferDocument> jobOfferDocuments = dao.getJobByCity(city, pageable);
    return jobOfferDocuments.map(mapper::DocumentToDTO);
  }
}
