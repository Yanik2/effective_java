package org.example.function;

import java.util.function.UnaryOperator;

//Represents operator that accepts one argument of paramterized type and produces value of the same
//type
public class UnaryOperatorImpl implements UnaryOperator<String> {
  @Override
  public String apply(String s) {
    return s.toLowerCase();
  }
}
