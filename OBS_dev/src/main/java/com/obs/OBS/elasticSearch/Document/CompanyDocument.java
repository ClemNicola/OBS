package com.obs.OBS.elasticSearch.Document;

import com.obs.OBS.company.SECTORS;
import com.obs.OBS.company.COMPANYTYPE;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "companies")
public class CompanyDocument {
  @Id
  @Field(type = FieldType.Keyword)
  private String id;

  @Field(type = FieldType.Text, analyzer = "autocomplete_index", searchAnalyzer = "autocomplete_search")
  private String name;

  @Field(type = FieldType.Text)
  private String description;

  @Field(type = FieldType.Keyword)
  private SECTORS sectors;

  @Field(type = FieldType.Keyword)
  private COMPANYTYPE companyType;

  @Field(type = FieldType.Text)
  private String address;

  @Field(type = FieldType.Keyword)
  private String city;

  @Field(type = FieldType.Keyword)
  private String country;

  @Field(type = FieldType.Keyword)
  private String zip;

  @Field(type = FieldType.Keyword)
  private String webUrl;

  @Field(type = FieldType.Keyword)
  private String companyEmail;

  @Field(type = FieldType.Keyword)
  private String siret;

  @Field(type = FieldType.Text)
  private String adminName;

  @Field(type = FieldType.Object)
  private UserDocument user;
}
