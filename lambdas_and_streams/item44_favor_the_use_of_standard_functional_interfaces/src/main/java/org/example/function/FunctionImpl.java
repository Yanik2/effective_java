package org.example.function;

import java.util.function.Function;

//Represents function that accepts one argument and produces result
//First parameter argument type, second return type
public class FunctionImpl implements Function<String, Integer> {
  @Override
  public Integer apply(String s) {
    return Integer.valueOf(s);
  }
}
