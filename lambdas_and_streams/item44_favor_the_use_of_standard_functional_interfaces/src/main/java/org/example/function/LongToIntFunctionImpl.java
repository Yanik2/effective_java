package org.example.function;

import java.util.function.LongToIntFunction;

//Represent function that applies on one long argument and produces int value
//It's important to use this interface in favor of standard Function when dealing with
//primitive types cause it can has significant impact on performance
public class LongToIntFunctionImpl implements LongToIntFunction {
  @Override
  public int applyAsInt(long l) {
    return 0;
  }
}
