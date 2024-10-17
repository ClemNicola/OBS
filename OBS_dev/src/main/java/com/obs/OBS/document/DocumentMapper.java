package com.obs.OBS.document;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class DocumentMapper {
  public DocumentDTO toDto (Document document){
    DocumentDTO dto = new DocumentDTO();
    dto.setId(document.getId());
    dto.setName(document.getName());
    dto.setType(document.getType());
    dto.setSize(document.getSize());
    dto.setData(document.getData());
    dto.setSeekerId(document.getSeeker().getId());
    return dto;
  }

  public Document toEntity (DocumentDTO dto){
    Document doc = new Document();
    doc.setId(dto.getId());
    doc.setName(dto.getName());
    doc.setType(dto.getType());
    doc.setSize(dto.getSize());
    doc.setData(dto.getData());
    doc.setId(dto.getSeekerId());
    return doc;
  }

  public List<DocumentDTO> toDtos(Collection<Document> docs){
    return docs.stream().map(this::toDto).collect(Collectors.toList());
  }

  public List<Document> toEntities(Collection<DocumentDTO> dtos){
    return dtos.stream().map(this::toEntity).collect(Collectors.toList());
  }
}
