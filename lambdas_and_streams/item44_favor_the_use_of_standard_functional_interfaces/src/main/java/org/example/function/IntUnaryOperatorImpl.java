package org.example.function;

import java.util.function.IntUnaryOperator;

//Represents operation applies on int argument and produces int value
// It's important to use this interface in favor of standard UnaryOperator when dealing with
// primitive unboxed types cause it can have significant impact on performance
public class IntUnaryOperatorImpl implements IntUnaryOperator {
  @Override
  public int applyAsInt(int i) {
    return i;
  }
}
