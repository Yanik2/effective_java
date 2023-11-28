package org.example.function;

import java.util.function.LongFunction;

//Represents function that takes one long argument and produces parameterized value
//It's important to use this interface in favor of standard Function when dealing with
//primitive unboxed types cause it can have significant impact on performance
public class LongFunctionImpl implements LongFunction<String> {
  @Override
  public String apply(long l) {
    return String.valueOf(l);
  }
}
