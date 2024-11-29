package com.obs.OBS.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.obs.OBS.user.UserType;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AuthResponse {
  private String token;
  private String type = "Bearer ";
  private UserType userType;

  public AuthResponse(String token,UserType userType) {

    this.token = token;
    this.userType = userType;
  }
}
