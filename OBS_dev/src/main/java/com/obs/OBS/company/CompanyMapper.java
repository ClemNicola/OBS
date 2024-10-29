package com.obs.OBS.company;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {
  public CompanyDTO toDTO(Company company){
    CompanyDTO dto = new CompanyDTO();
    dto.setId(company.getId());
    dto.setEmail(company.getEmail());
    dto.setPassword(company.getPassword());
    dto.setUserType(company.getType());
    dto.setName(company.getName());
    dto.setDescription(company.getDescription());
    dto.setSectors(company.getSectors());
    dto.setCompanyType(company.getCompanyType());
    dto.setAddress(company.getAddress());
    dto.setCity(company.getCity());
    dto.setCountry(company.getCountry());
    dto.setZip(company.getZip());
    dto.setWebUrl(company.getWebUrl());
    dto.setCompanyEmail(company.getCompanyEmail());
    dto.setSiret(company.getSiret());
    dto.setAdminName(company.getAdminName());

    return dto;
  }

  public Company toEntity(CompanyDTO companyDTO){
    Company company = new Company();
    company.setId(companyDTO.getId());
    company.setEmail(companyDTO.getEmail());
    company.setPassword(companyDTO.getPassword());
    company.setName(companyDTO.getName());
    company.setDescription(companyDTO.getDescription());
    company.setSectors(companyDTO.getSectors());
    company.setCompanyType(companyDTO.getCompanyType());
    company.setAddress(companyDTO.getAddress());
    company.setCity(companyDTO.getCity());
    company.setCountry(companyDTO.getCountry());
    company.setZip(companyDTO.getZip());
    company.setWebUrl(companyDTO.getWebUrl());
    company.setCompanyEmail(companyDTO.getCompanyEmail());
    company.setSiret(companyDTO.getSiret());
    company.setAdminName(companyDTO.getAdminName());

    return company;
  }

  public List<CompanyDTO> toDTOs(List<Company> companies){
    return companies.stream().map(this::toDTO).collect(Collectors.toList());
  }
}
