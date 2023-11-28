package org.example.function;

import java.util.function.ToLongFunction;

//Represents function that accepts one argument of paramterized type and produces long value
//It's impotant to use this interface in favor of standard Function when dealing with
//primitive unboxed types cause it can have significant impact on performance
public class ToLongFunctionImpl  implements ToLongFunction<String> {
  @Override
  public long applyAsLong(String s) {
    return s.length();
  }
}
