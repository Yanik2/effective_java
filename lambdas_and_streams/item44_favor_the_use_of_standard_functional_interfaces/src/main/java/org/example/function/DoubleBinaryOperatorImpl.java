package org.example.function;

import java.util.function.DoubleBinaryOperator;

//Represents operation applied to 2 double arguments and producing double value
// It's important to use this interface in case of dealing with unboxed primitive types
// because it can have significant impact on performance
public class DoubleBinaryOperatorImpl implements DoubleBinaryOperator {
  @Override
  public double applyAsDouble(double v, double v1) {
    return v + v1;
  }
}
