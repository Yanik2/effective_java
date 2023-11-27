package org.example;

import static org.example.Operation.PLUS;

public class Main {
  public static void main(String[] args) {
    final var result = PLUS.apply(3, 4);
    System.out.println("Result " + result);
  }
}