package com.obs.OBS.jobSeeker;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class SeekerMapper {

  public SeekerDTO toDto (Seeker entity){
    SeekerDTO seekerDTO = new SeekerDTO();
    seekerDTO.setId(entity.getId());
    seekerDTO.setFirstName(entity.getFirstName());
    seekerDTO.setLastName(entity.getLastName());
    seekerDTO.setPhoneNumber(entity.getPhoneNumber());
    seekerDTO.setEmail(entity.getEmail());
    seekerDTO.setPassword(entity.getPassword());
    seekerDTO.setUserType(entity.getType());
    seekerDTO.setContractType(entity.getContractType());
    seekerDTO.setDesiredLocations(entity.getDesiredLocations());
    seekerDTO.setDescription(entity.getDescription());

    return seekerDTO;
  }

  public Seeker toEntity (SeekerDTO dto){
    Seeker seeker = new Seeker();
    seeker.setFirstName(dto.getFirstName());
    seeker.setLastName(dto.getLastName());
    seeker.setPhoneNumber(dto.getPhoneNumber());
    seeker.setEmail(dto.getEmail());
    seeker.setPassword(dto.getPassword());
    seeker.setContractType(dto.getContractType());
    seeker.setDesiredLocations(dto.getDesiredLocations());
    seeker.setDescription(dto.getDescription());

    return seeker;
  }

  public List<SeekerDTO> toDtos (Collection<Seeker> entities){
    return entities.stream().map(this::toDto).collect(Collectors.toList());
  }

}
