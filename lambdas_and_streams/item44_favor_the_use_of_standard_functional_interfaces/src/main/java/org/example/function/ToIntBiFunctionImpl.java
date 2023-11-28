package org.example.function;

import java.util.Date;
import java.util.function.ToIntBiFunction;

//Represents function that accepts two paramterized types arguments and produces int value
//It's important to use this interface in favor of standard BiFunction when dealing with
//primitive unboxed types cause it can have significant impact on performance
public class ToIntBiFunctionImpl implements ToIntBiFunction<String, Date> {
  @Override
  public int applyAsInt(String s, Date s2) {
    return 0;
  }
}
