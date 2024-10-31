package com.obs.OBS.company;

import lombok.Getter;

@Getter
public enum COMPANYTYPE {
  PME("20 à 249 employés"), TPE(" < 20 employés"), ETI("250 à 4999 employés"), GE("> 5000 employés");
  public final String label;

  COMPANYTYPE(String label){
    this.label = label;
  }

}
