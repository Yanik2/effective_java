package org.example.function;

import java.util.function.LongUnaryOperator;

//Represents operation that applies on one long argument and produces long value
//It's important to use this interface in favor of standard UnaryOperator when dealing with
//primitive types cause it can have significant impact on performance
public class LongUnaryOperatotImpl implements LongUnaryOperator {
  @Override
  public long applyAsLong(long l) {
    return l;
  }
}
