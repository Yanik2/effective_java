package org.example.function;

import java.util.function.IntToDoubleFunction;

//Represents function that takes one int argument and produces double values
// It's important to use this interface in favor of standard Supplier when dealing with
// primitive unboxed types cause it can have significant impact on performance
public class IntToDoubleFunctionImpl implements IntToDoubleFunction {
  @Override
  public double applyAsDouble(int i) {
    return i;
  }
}
