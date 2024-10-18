package com.obs.OBS.document;

import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

  @GetMapping("/all/{seekerId}")
  public List<DocumentDTO> getAllDocuments(@PathVariable String seekerId){
    return service.getAllBySeekerId(seekerId);
  }

  @PostMapping("/upload/{seekerId}")
  public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable("seekerId") String seekerId)
      throws IOException {
    service.storeDocument(file, seekerId);
    return ResponseEntity.status(HttpStatus.OK).body("File uploaded successfully");
  }

  @DeleteMapping("/{id}")
  public void deleteDocument(@PathVariable String id){
    service.deleteById(id);
  }
}
