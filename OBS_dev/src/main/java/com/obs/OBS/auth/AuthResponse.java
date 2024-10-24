package com.obs.OBS.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AuthResponse {
  private String token;
  private String type = "Bearer ";

  public AuthResponse(String token) {
    this.token = token;
  }
}
