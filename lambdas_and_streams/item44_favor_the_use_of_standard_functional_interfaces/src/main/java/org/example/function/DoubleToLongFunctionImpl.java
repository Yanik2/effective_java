package org.example.function;

import java.util.function.DoubleToLongFunction;

//Represents function that takes double as argument and produces int value
// It's important to use this interface in favor of standard Function when dealing with
// primitive unboxed types cause it can have significant impact on performance
public class DoubleToLongFunctionImpl implements DoubleToLongFunction {
  @Override
  public long applyAsLong(double v) {
    return Math.round(v);
  }
}
