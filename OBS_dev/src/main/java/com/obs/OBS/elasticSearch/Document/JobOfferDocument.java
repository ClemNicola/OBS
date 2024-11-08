package com.obs.OBS.elasticSearch.Document;

import com.obs.OBS.jobOffer.EXPERIENCE;
import com.obs.OBS.jobOffer.MODE;
import com.obs.OBS.jobOffer.STATUS;
import com.obs.OBS.jobSeeker.CONTRACT;
import jakarta.persistence.Id;
import java.util.Date;
import java.util.Set;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "joboffers")
public class JobOfferDocument {
  @Id
  @Field(type = FieldType.Keyword)
  private String id;

  @Field(type = FieldType.Text, analyzer = "autocomplete_index", searchAnalyzer = "autocomplete_search")
  private String jobTitle;

  @Field(type = FieldType.Text)
  private String description;

  @Field(type = FieldType.Keyword, analyzer = "autocomplete_index", searchAnalyzer = "autocomplete_search")
  private Set<String> skills;

  @Field(type = FieldType.Date, format = DateFormat.date_optional_time)
  private Date publicationDate;

  @Field(type = FieldType.Keyword, analyzer = "autocomplete_index", searchAnalyzer = "autocomplete_search")
  private String city;

  @Field(type = FieldType.Keyword)
  private String country;

  @Field(type = FieldType.Keyword)
  private MODE mode;

  @Field(type = FieldType.Keyword)
  private CONTRACT contract;

  @Field(type = FieldType.Keyword)
  private String contractDuration;

  @Field(type = FieldType.Integer)
  private Integer minSalary;

  @Field(type = FieldType.Integer)
  private Integer maxSalary;

  @Field(type = FieldType.Keyword)
  private EXPERIENCE experience;

  @Field(type = FieldType.Keyword)
  private STATUS status = STATUS.OPEN;

  @Field(type = FieldType.Keyword)
  private Set<String> tags;

  @Field(type = FieldType.Integer)
  private Integer numberOfApplicants;

  @Field(type = FieldType.Keyword, analyzer = "autocomplete_index", searchAnalyzer = "autocomplete_search")
  private String companyName;

  @Field(type = FieldType.Object)
  private CompanyDocument company;
}
