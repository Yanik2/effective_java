package org.example.function;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class FunctionMain {
  public static void main(String[] args) {
    final var list = List.of("asdf", "fdsa", "qwer");

    final var result = list.stream()
        .map(identity())
        .toList();

    final var result2 = list.stream()
        .map(identity2())
        .toList();

    final var result3 = list.stream()
        .map(identity2())
        .toList();

    //All three are the same object
    final var id = identity2();
    final var id2 = identity2();
    final var id3 = identity2();
    //TRUE
    final var lambdaEquals = (id == id2) && (id2 == id3);

    //All three are different objects
    final var id4 = identity3();
    final var id5 = identity3();
    final var id6 = identity3();
    //FALSE
    final var objectEquals = (id4 == id5) && (id5 == id6);
    System.out.println(result);
  }

  private static Function<Object, Object> IDENTITY = (t) -> t;

  private static <T> Function<T, T> identity() {
    return (Function<T, T>) IDENTITY;
  }

  //Returns the same object on each call
  private static <T> Function<T, T> identity2() {
    return t -> t;
  }

  //Return new object on each call
  private static <T> Function<T, T> identity3() {
    return new FunctionImpl<T>();
  }
}
