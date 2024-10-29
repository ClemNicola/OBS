package com.obs.OBS.document;

import com.obs.OBS.jobSeeker.Seeker;
import com.obs.OBS.jobSeeker.SeekerDAO;
import jakarta.persistence.EntityNotFoundException;
import java.io.IOException;
import java.text.Normalizer;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
@RequiredArgsConstructor
@Slf4j
public class DocumentServiceImpl implements DocumentService{
  private final DocumentDAO dao;
  private final DocumentMapper mapper;
  private final SeekerDAO seekerDAO;

  @Override
  public DocumentDTO getById(String id) {
    return mapper.toDto(dao.getById(id).orElseThrow(() -> new EntityNotFoundException("can't find document with id: " + id)));
  }

  @Override
  public List<DocumentDTO> getAllBySeekerId(String seekerId) {
    if(!seekerDAO.seekerIsExisting(seekerId)){
      throw new EntityNotFoundException("Can't find seeker with id: " + seekerId);
    }

    return  mapper.toDtos(dao.getAllBySeekerId(seekerId));
  }

  @Override
  public void deleteById(String id) {
    if(dao.isExistingById(id)){
      dao.delete(id);
    }else {
      throw new RuntimeException("Can't delete document with id: " + id);
    }
  }

  @Override
  public void storeDocument(MultipartFile file, String id) throws IOException {
    if(!"application/pdf".equals(file.getContentType())){
      throw new IllegalArgumentException("File must be a PDF");
    }

    long MAX_SIZE = 10 * 1024 * 1024;
    if(file.getSize() > MAX_SIZE){
      throw new IllegalArgumentException("File cannot exceed 10MB");
    }
    Seeker seeker = seekerDAO.getById(id).orElseThrow(() -> new EntityNotFoundException("Can't find seeker with id: " + id ));
    Document document = new Document();
    document.setId(UUID.randomUUID().toString());
    document.setName(sanitizeFileName(Objects.requireNonNull(file.getOriginalFilename())));
    document.setType(file.getContentType());
    document.setSize(file.getSize());
    document.setData(file.getBytes());
    document.setSeeker(seeker);

    mapper.toDto(dao.create(document));
  }

  private String sanitizeFileName(String fileName){
    String normalized = Normalizer.normalize(fileName, Normalizer.Form.NFD);
    String withoutAccent = normalized.replaceAll("\\p{InCOMBINING_DIACRITICAL_MARKS}+","");
    return withoutAccent.replaceAll("[^a-zA-Z0-9.-]", "_");
  }
}
