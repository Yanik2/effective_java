package org.example.function;

import java.util.function.DoubleToIntFunction;

//Represents function that takes double as argument and produces int value
// It's important to use this interface in favor of standard Function when dealing with
// primitive unboxed types cause it can have significant impact on performance
public class DoubleToIntFunctionImpl implements DoubleToIntFunction {
  @Override
  public int applyAsInt(double v) {
    return Math.getExponent(v);
  }
}
