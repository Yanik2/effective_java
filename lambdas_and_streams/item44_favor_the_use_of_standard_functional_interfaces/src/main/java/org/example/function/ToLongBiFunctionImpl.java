package org.example.function;

import java.util.Date;
import java.util.function.ToLongBiFunction;

//Represents function that accepts to arguments of paramterized type and produces long value
//It's important to use this interface in favor of standard BiFunction when dealing with
//primitive unboxed types cause it can have significant impact on performance
public class ToLongBiFunctionImpl implements ToLongBiFunction<String, Date> {
  @Override
  public long applyAsLong(String s, Date date) {
    return s.length() + date.getTime();
  }
}
