package org.example.function;

import java.util.function.BooleanSupplier;

//Represents supplier which produces boolean value
public class BooleanSupplierImpl implements BooleanSupplier {
  @Override
  public boolean getAsBoolean() {
    return Boolean.FALSE;
  }
}
