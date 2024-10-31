package com.obs.OBS.company;

import lombok.Getter;

@Getter
public enum SECTORS {
  FINANCE("Finance"), PHARMA("Pharmaceutique"), BUILD("Batiment-Construction"), AUTO("Automobile"), RETAIL("Commerce et e-commerce"),
  HEALTH("Santé"), ENERGY("Energies"), EDUCATION("Education"), INSURANCE("Assurance"), PUBLIC("Public"), TMT("Telecom - Media - Technologie");

  public final String label;

  SECTORS(String label){
    this.label = label;
  }

}
