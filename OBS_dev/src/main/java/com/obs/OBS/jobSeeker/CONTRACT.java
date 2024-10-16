package com.obs.OBS.jobSeeker;

public enum CONTRACT {
  FULL("cdi"), PART("cdd"), INTERIM("intérim"), INTERNSHIP("Stage"), FREELANCE("freelance"), WORK_STUDY("alternace");

  public final String label;

  CONTRACT(String label) {
    this.label = label;
  }

  public String getLabel() {
    return label;
  }
}
