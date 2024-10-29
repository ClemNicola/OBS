package com.obs.OBS.user;

public enum UserType {
  SEEKER("jobSeeker"), COMPANY("company");
  public final String label;

  UserType(String label){
    this.label = label;
  }

  public String getLabel() {
    return label;
  }
}
