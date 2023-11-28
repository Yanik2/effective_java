package org.example.function;

import java.util.function.IntFunction;

//Represents function that accepts one argument of int type and return result of parameterized type
// It's important to use this interface in favor of standard Function when dealing with
// primitive unboxed types cause it can have significant impact on performance
public class IntFunctionImpl implements IntFunction<String> {
  @Override
  public String apply(int i) {
    return String.valueOf(i);
  }
}
