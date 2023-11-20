package org.example.ordinal;

//this appropriate implementation
// basically avoid ordinal as mush as you can, better to not use it at all
public enum EnsembleWithValue {
  SOLO(1),
  DUET(2),
  TRIO(3),
  QUARTET(4);

  private final int value;

  EnsembleWithValue(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
