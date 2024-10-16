package com.obs.OBS.document;

import com.obs.OBS.jobSeeker.Seeker;
import com.obs.OBS.jobSeeker.SeekerDAO;
import jakarta.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService{
  private final DocumentDAO dao;
  private final DocumentMapper mapper;
  private final SeekerDAO seekerDAO;

  @Override
  public DocumentDTO getById(String id) {
    return mapper.toDto(dao.getById(id).orElseThrow(() -> new EntityNotFoundException("can't find document with id: " + id)));
  }

  @Override
  public List<DocumentDTO> getAll() {
    return  mapper.toDtos(dao.getAll());
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
    Seeker seeker = seekerDAO.getById(id).orElseThrow(() -> new EntityNotFoundException("Can't find seeker with id: " + id ));
    Document document = new Document();
    document.setId(UUID.randomUUID().toString());
    document.setName(file.getOriginalFilename());
    document.setType(file.getContentType());
    document.setData(file.getBytes());
    document.setSeeker(seeker);

    mapper.toDto(dao.create(document));
  }
}
