package com.obs.OBS.elasticSearch.Document;

import com.obs.OBS.jobSeeker.CONTRACT;
import jakarta.persistence.Id;
import java.util.Set;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "seekers")
public class SeekerDocument {
  @Id
  @Field(type = FieldType.Keyword)
  private String id;

  @Field(type = FieldType.Text)
  private String firstName;

  @Field(type = FieldType.Text)
  private String lastName;

  @Field(type = FieldType.Keyword)
  private String phoneNumber;

  @Field(type = FieldType.Keyword)
  private Set<CONTRACT> contractType;

  @Field(type = FieldType.Keyword)
  private Set<String> desiredLocations;

  @Field(type = FieldType.Text)
  private String description;

  @Field(type = FieldType.Object)
  private UserDocument user;
}
