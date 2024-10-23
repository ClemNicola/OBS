package com.obs.OBS.jobSeeker;


import com.obs.OBS.document.DocumentDTO;
import com.obs.OBS.document.DocumentService;
import java.util.List;
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
@RequestMapping(path="/seeker")
public class SeekerController {
  private final SeekerService service;
  private final DocumentService documentService;


  @GetMapping("/{id}")
  public SeekerDTO getById(@PathVariable String id){
    return service.getById(id);
  }

  @GetMapping("/seekers")
  public List<SeekerDTO> getAll(){
    return service.getAll();
  }

  @GetMapping("/seeker/{id}/documents")
  public List<DocumentDTO> getDocuments(@PathVariable String id){
    return documentService.getAllBySeekerId(id);
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
