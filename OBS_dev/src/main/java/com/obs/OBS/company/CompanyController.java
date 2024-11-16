package com.obs.OBS.company;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/company")
public class CompanyController {
  private final CompanyService service;

  @GetMapping("/{id}")
  public CompanyDTO getById(@PathVariable String id){
    return service.getById(id);
  }

  @PutMapping("/{id}")
  public CompanyDTO updateCompany(@PathVariable String id, @RequestBody CompanyDTO dto){
    return service.updateCompany(id, dto);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable String id){
    service.deleteById(id);
  }
}
