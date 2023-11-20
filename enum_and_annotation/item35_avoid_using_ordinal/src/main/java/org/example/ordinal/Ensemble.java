package org.example.ordinal;

public enum Ensemble {
  SOLO, DUET, TRIO, QUARTET;

  //Don't use it like this, it become maintenance nightmare
  // if you want to add some value between DUET and TRIO it will break all ordinals methods
  // after DUET
  // if you want to add OCTET, you would need to add some dummy values between QUARTET and OCTET
  //to fill numbers 5, 6, 7
  //see EnsembleWithValues enum class for correct implementation
  // basically avoid ordinal as mush as you can, better to not use it at all
  public int numberOfMusicians() {
    return this.ordinal() + 1;
  }
}
