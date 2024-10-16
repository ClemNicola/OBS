package com.obs.OBS.document;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/api/documents")
public class DocumentController {
  private final DocumentService service;

  @GetMapping("/{id}")
  public DocumentDTO getDocument(@PathVariable String id){
    return service.getById(id);
  }

  @GetMapping
  public List<DocumentDTO> getAllDocuments(){
    return service.getAll();
  }

  @PostMapping("/upload")
  public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("seekerId") String seekerId){
    return null;
  }
}
