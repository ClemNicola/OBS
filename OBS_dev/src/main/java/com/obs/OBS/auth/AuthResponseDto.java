package com.obs.OBS.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class AuthResponseDto {
  private String token;
  private String type = "Bearer ";

  public AuthResponseDto(String token) {
    this.token = token;
  }
}
