package org.example;

import java.util.LinkedHashMap;

// Java has 6 basic functional interfaces
//1. UnaryOperator<T> argument type and return type are the same
//    example: String::toLowerCase
//2. BinaryOperator<T> arguments types and return type are the same
//    example: BigInteger::add
//3. Predicate<T> one argument type is parameterized and return type is T
//    exapmple: Collection::isEmpty
//4. Supplier<T> takes no arguments but return object
//    example: Instant::now
//5. Consumer<T> takes one argument, returns nothing
//    example: System.out::println
public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }

  private static void test() {
    final var map = new LinkedHashMap<String, String>();
  }
}