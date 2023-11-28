package org.example;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Main {
  public static void main(String[] args) {
    var map = new HashMap<String, Integer>();

    for (int i = 0; i < 10; i++) {
      merge1(map, i);
    }

    System.out.println(map);

    map = new HashMap<String, Integer>();

    for (int i = 0; i < 10; i++) {
      merge2(map, i);
    }

    System.out.println(map);
  }

  //with lambda
  private static void merge1(Map<String, Integer> map, Integer value) {
    map.merge("asdf", value, (initial, newValue) -> initial + newValue);
  }

  //with method reference, much less verbose and more short and readable
  private static void merge2(Map<String, Integer> map, Integer value) {
    map.merge("asdf", value, Integer::sum);
  }

  // Five kinds of method references
  //1. Static
  //2. Bound
  //3. Unbound
  //4. Class Constructor
  //5. Array Contructor
  //Examples below


  // Static
  private static void staticReference() {
    List.of("1")
        .stream()
        //Integer::valueOf is static method reference
        //equivalent to: str -> Integer.valueOf(str)
        .map(Integer::valueOf)
        .toList();
  }

  // Bound
  private static void boundReference() {
    List.of(Instant.MIN)
        .stream()
        // Instant.now()::isAfter bound method reference
        // equivalent to: final var instant = Instant.now(); t -> instant.isAfter(t);
        .filter(Instant.now()::isAfter)
        .toList();
  }

  // Unbound
  private static void unboundReference() {
    List.of("ASDF")
        .stream()
        // String::toLowerCase unbound method reference
        // equivalent to str -> str.toLowerCase();
        .map(String::toLowerCase)
        .toList();
  }

  //Class Constructor
  private static void classConstructorReference() {
    List.of(List.of("asdf"))
        //ArrayList<String>::new class constructor method reference
        //equivalent to: (list) -> new ArrayList<String>(list);
        .forEach(ArrayList<String>::new);
  }

  // Array constructor
  private static void arrayConstructorReference() {
    List.of(1)
        .stream()
        // array constructor reference
        //equivalent to (len) -> new int[len];
        .map(int[]::new)
        .toList();
  }
}