package org.example.function;

import java.util.function.IntSupplier;

//Represents supplier that supplies int values and takes no arguments
// It's important to use this interface in favor of standard Supplier when dealing with
// primitive unboxed types cause it can have significant impact on performance
public class IntSupplierImpl implements IntSupplier {
  @Override
  public int getAsInt() {
    return 0;
  }
}
