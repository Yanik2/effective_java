package org.example.function;

import java.util.function.IntPredicate;

//Represents predicate which tests int argument value and produces boolean result
// It's important to use this interface in favor of standard Function when dealing with
// primitive unboxed types cause it can have significant impact on performance
public class IntPredicateImpl implements IntPredicate {
  @Override
  public boolean test(int i) {
    return i > 0;
  }
}
