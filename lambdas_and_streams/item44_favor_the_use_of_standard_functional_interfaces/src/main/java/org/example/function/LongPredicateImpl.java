package org.example.function;

import java.util.function.LongPredicate;

//Represents predicate that takes one long argument and produces boolean value
//It's important to use this interface in favor on standard Predicate when dealing with
//primitive types cause it can have significant impact on performance
public class LongPredicateImpl implements LongPredicate {
  @Override
  public boolean test(long l) {
    return l > 0;
  }
}
