package org.example.function;

import java.util.function.DoublePredicate;

//Represents predicate that tests double value and produces boolean value
// It's important to use this interface in favor of standard Predicate when dealing with
// primitive unboxed types cause it can have significant impact on performance
public class DoublePredicateImpl implements DoublePredicate {
  @Override
  public boolean test(double v) {
    return v < 1.0;
  }
}
