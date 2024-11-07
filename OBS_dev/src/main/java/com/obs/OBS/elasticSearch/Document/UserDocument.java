package com.obs.OBS.elasticSearch.Document;

import com.obs.OBS.user.UserType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "users")
public class UserDocument {
  @Id
  @Field(type = FieldType.Keyword)
  private String email;

  @Field(type = FieldType.Keyword)
  private String password;

  @Field(type = FieldType.Keyword)
  private UserType type;
}
