package org.example;

import java.util.function.DoubleBinaryOperator;

//This is enum from item34 refactored with lambda instead of implementation
//looks mush compact and readable
public enum Operation {
  PLUS("+", (x, y) -> x + y),
  MINUS("-", (x, y) -> x - y),
  TIMES("*", (x, y) -> x * y),
  DIVIDE("/", (x, y) -> x / y);

  private final String symbol;
  private final DoubleBinaryOperator operator;

  Operation(String symbol, DoubleBinaryOperator operator) {
    this.symbol = symbol;
    this.operator = operator;
  }

  public double apply(double x, double y) {
    return this.operator.applyAsDouble(x, y);
  }
}
