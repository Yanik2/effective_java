package org.example.function;

import java.util.function.LongToDoubleFunction;

//Represents function that applies on one long argument and produces double value
//It's important to use this interface in favor of standard Function when dealing with
// primitive types cause it can has significant impact on performance
public class LongToDoubleFunctionImpl implements LongToDoubleFunction {
  @Override
  public double applyAsDouble(long l) {
    return l;
  }
}
