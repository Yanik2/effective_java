package org.example.function;

import java.util.function.BiPredicate;

// Represents BiPredicate that accepts 2 arguments and produces boolean value
public class BiPredicateImpl implements BiPredicate<String, Integer> {
  @Override
  public boolean test(String s, Integer integer) {
    final var sToInt = Integer.parseInt(s);
    return integer == sToInt;
  }
}
