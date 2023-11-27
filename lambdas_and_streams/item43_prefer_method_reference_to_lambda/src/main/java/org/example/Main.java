package org.example;

import java.util.HashMap;
import java.util.Map;

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
}