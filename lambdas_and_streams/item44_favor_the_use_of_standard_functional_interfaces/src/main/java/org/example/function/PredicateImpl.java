package org.example.function;

import java.util.function.Predicate;

//Represents predicate that accepts on argument of parameterized type and produces boolean value
public class PredicateImpl implements Predicate<String> {
  @Override
  public boolean test(String s) {
    return s != null;
  }
}
