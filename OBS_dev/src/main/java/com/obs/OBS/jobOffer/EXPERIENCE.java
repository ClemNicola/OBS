package com.obs.OBS.jobOffer;

import lombok.Getter;

@Getter
public enum EXPERIENCE {
  SENIOR("Senior"), CLEVEL("C-level"), RETRAINING("Reconversion");
  public final String label;
  EXPERIENCE(String label){
    this.label = label;
  }

}
