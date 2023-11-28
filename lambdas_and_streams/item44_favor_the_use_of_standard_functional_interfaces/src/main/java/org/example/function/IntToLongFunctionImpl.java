package org.example.function;

import java.util.function.IntToLongFunction;

//Represents function that takes one int argument and produces long result
// It's important to use this interface in favor of standard Function when dealing with
// primitive unboxed types cause it can have significant impact on performance
public class IntToLongFunctionImpl implements IntToLongFunction {
  @Override
  public long applyAsLong(int i) {
    return i;
  }
}
