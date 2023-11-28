package org.example.function;

import java.util.function.ToIntFunction;

//Represents function that accepts one argumennt or paramterized type and produces int value
//It's important to use this interface in favor if standard Function when dealing with
//primitive unboxed types cause it can have significant impact on performance
public class ToIntFunctionImpl implements ToIntFunction<String> {
  @Override
  public int applyAsInt(String s) {
    return s.length();
  }
}
