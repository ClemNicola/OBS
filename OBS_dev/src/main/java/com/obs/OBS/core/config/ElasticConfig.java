package com.obs.OBS.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

@Configuration
public class ElasticConfig extends ElasticsearchConfiguration {

  @Value("${spring.elasticsearch.uris}")
  private String host;

  @Value("${spring.elasticsearch.username}")
  private String username;

  @Value("${spring.elasticsearch.password}")
  private String password;

  @Override
  public ClientConfiguration clientConfiguration() {
    return ClientConfiguration.builder()
        .connectedTo(host)
        .withBasicAuth(username, password)
        .build();
  }
}
