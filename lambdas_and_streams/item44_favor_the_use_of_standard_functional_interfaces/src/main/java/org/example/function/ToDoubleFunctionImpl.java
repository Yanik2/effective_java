package org.example.function;

import java.util.function.ToDoubleFunction;

//Represents function that takes parameterized type argument and produces double value
//It's important to use this interface in favor of standard Function when dealing with
//primitive unboxed types cause it can have significant impact on performance
public class ToDoubleFunctionImpl implements ToDoubleFunction<String> {
  @Override
  public double applyAsDouble(String s) {
    return s.length();
  }
}
