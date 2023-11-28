package org.example.function;

import java.util.function.DoubleSupplier;

//Represents a supplier of double values
// It's important to use this interface in favor of standard Supplier when dealing with
// primitive unboxed types cause it can have significant impact on performance
public class DoubleSupplierImpl implements DoubleSupplier {
  @Override
  public double getAsDouble() {
    return 0;
  }
}
