package com.obs.OBS.jobOffer;

import lombok.Getter;

@Getter
public enum STATUS {
  OPEN("Ouverte"), CLOSE("Fermée"), IN_PROGRESS("En cours");
  public final String label;
  STATUS(String label){
    this.label = label;
  }

}
