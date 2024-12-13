package com.obs.OBS.jobOffer;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/job")
public class JobController {
  private final JobService service;

  @GetMapping("/{id}")
  public JobDTO getJobById(@PathVariable String id){
    return service.getJobById(id);
  }

  @GetMapping("/all/{companyId}")
  public Page<JobDTO> getJobsByCompanyId(
      @PathVariable String companyId,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "30") int size){
    return service.getAllJobsByCompanyId(companyId, PageRequest.of(page, size));
  }

  @GetMapping("/all")
  public Page<JobDTO> getAllJobs(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "30") int size){
    return service.getAllJobs(PageRequest.of(page, size));
  }

  @GetMapping("/search")
  public Page<JobDTO> searchJobByJobTitle(
      @RequestParam String jobTitle,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "30") int size){
    return service.searchJobByTitle(jobTitle,PageRequest.of(page, size));
  }

  @GetMapping("/search/skills")
  public Page<JobDTO> searchJobBySkills(
      @RequestParam String skills,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "30") int size){
    return service.searchJobBySkills(skills,PageRequest.of(page, size));
  }


  @GetMapping("/search/city")
  public Page<JobDTO> searchJobByCity(
      @RequestParam String city,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "30") int size){
    return service.searchJobByCity(city,PageRequest.of(page, size));
  }
  @GetMapping("/search/company")
  public Page<JobDTO> searchJobByCompanyName(
      @RequestParam String companyName,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "30") int size){
    return service.searchJobByCompanyName(companyName,PageRequest.of(page, size));
  }

  @PostMapping("/create/{companyId}")
  public JobDTO createJob(@PathVariable String companyId,@RequestBody JobDTO dto){
    return service.createJobOffer(companyId, dto);
  }

  @PutMapping("/update/{id}")
  public JobDTO updateJob(@PathVariable String id, @RequestBody JobDTO dto){
    return service.updateJobOffer(id, dto);
  }

  @DeleteMapping("/delete/{id}")
  public void deleteJob(@PathVariable String id){
    service.deleteJobOffer(id);
  }


}
