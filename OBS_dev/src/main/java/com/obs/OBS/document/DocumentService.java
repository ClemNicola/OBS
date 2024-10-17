package com.obs.OBS.document;

import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface DocumentService {
  DocumentDTO getById(String id);
  List<DocumentDTO> getAllBySeekerId(String seekerId);
  void deleteById(String id);
  void storeDocument(MultipartFile file, String id) throws IOException;
}
