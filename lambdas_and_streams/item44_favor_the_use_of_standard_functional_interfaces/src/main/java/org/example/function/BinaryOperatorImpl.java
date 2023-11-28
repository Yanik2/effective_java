package org.example.function;

import java.util.function.BinaryOperator;

//Represents operation applied to 2 operands of the same type and produces result of the same type
// that operands
public class BinaryOperatorImpl implements BinaryOperator<String> {
  @Override
  public String apply(String s, String s2) {
    return s + s;
  }
}
