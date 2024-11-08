package com.obs.OBS.core.indexation;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/indexation")
@RequiredArgsConstructor
public class IndexationController {
  private final IndexationService service;
 @PostMapping("/full")
  public ResponseEntity<String> triggerFullIndexing(){
   service.indexFull();
   return ResponseEntity.ok("Indexation des documents réussie");
 }
}
