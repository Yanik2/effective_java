package org.example.function;

import java.util.function.IntBinaryOperator;

//Represents operation that applies on two values of the same int type and returns int type value
// It's important to use this interface in favor of standard BinaryOperator when dealing with
// primitive unboxed types cause it can have significant impact on performance
public class IntBinaryOperatorImpl implements IntBinaryOperator {
  @Override
  public int applyAsInt(int i, int i1) {
    return 0;
  }
}
