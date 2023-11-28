package org.example.function;

import java.util.function.LongSupplier;

//Represents supplier that don't take any arguments and produces long value
//It's important to use this interface in favor of standard Supplier when dealing with
//primitive types cause it can have significant impact on performance
public class LongSupplierImpl implements LongSupplier {
  @Override
  public long getAsLong() {
    return 1L;
  }
}
