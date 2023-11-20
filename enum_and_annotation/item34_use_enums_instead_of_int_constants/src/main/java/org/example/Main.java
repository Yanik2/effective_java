package org.example;

import org.example.abstraction.Operation;

public class Main {
  public static void main(String[] args) {
    final var result = calculate(Operation.PLUS, 1, 2);
    System.out.println(result);
  }

  private static double calculate(Operation operation, double x, double y) {
    return operation.apply(x, y);
  }
}