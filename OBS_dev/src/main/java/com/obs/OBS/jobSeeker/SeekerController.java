package com.obs.OBS.jobSeeker;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/api")
public class SeekerController {
  private final SeekerService service;


  @GetMapping("/{id}")
  public SeekerDTO getById(@PathVariable String id){
    return service.getById(id);
  }

  @PostMapping("/seeker")
  public void createSeeker(@RequestBody SeekerDTO dto){
    service.createSeeker(dto);
  }

  @PutMapping("/{id}")
  public void updateSeeker(@RequestBody SeekerDTO dto, @PathVariable String id){
    service.updateSeeker(id, dto);
  }

  @DeleteMapping("/{id}")
  public void deleteSeeker(@PathVariable String id){
    service.deleteSeeker(id);
  }
}
