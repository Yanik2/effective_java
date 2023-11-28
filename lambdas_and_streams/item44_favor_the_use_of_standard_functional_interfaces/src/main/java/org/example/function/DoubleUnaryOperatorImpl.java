package org.example.function;

import java.util.function.DoubleUnaryOperator;

//Represents operation on single value type of double and produces value of type double
// It's important to use this interface in favor of standard UnaryOperator when dealing with
// primitive unboxed types cause it can have significant impact on performance
public class DoubleUnaryOperatorImpl implements DoubleUnaryOperator {
  @Override
  public double applyAsDouble(double v) {
    return v + v;
  }
}
