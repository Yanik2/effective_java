package org.example.function;

import java.util.function.ToDoubleBiFunction;

//Represents function that takes two arguments of parameterized types and produces double value
//It's important to use this interface in favor of standard BiFunction when dealing with
//primitive unboxed types cause it can have significant impact on performance
public class ToDoubleBiFunctionImpl implements ToDoubleBiFunction<String, String> {
  @Override
  public double applyAsDouble(String s, String s2) {
    return Double.valueOf(s) + Double.valueOf(s2);
  }
}
