package org.example.function;

import java.util.function.DoubleFunction;

//Represent function applied on double value and produces given parameterized type
//It's important to use this interface in case of dealing with unboxed primitive types
// cause it can have significant impact on performance
public class DoubleFunctionImpl implements DoubleFunction<String> {
  @Override
  public String apply(double v) {
    return String.valueOf(v);
  }
}
