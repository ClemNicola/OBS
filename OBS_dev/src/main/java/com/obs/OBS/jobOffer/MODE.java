package com.obs.OBS.jobOffer;

import lombok.Getter;

@Getter
public enum MODE {
  REMOTE("Télétravail"), HYBRID("Hybride"), OFFICE("Présentiel");

  public final String label;
  MODE(String label){
    this.label = label;
  }

}
