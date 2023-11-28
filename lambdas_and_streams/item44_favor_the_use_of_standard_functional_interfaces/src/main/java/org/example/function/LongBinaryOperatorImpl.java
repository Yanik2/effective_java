package org.example.function;

import java.util.function.LongBinaryOperator;

//Represents operation applies on two long arguments and produces long value
// It's important to use this interface in favor of standard BinaryOperator when dealing with
// primitive unboxed types cause it can have significant impact on performance
public class LongBinaryOperatorImpl implements LongBinaryOperator {
  @Override
  public long applyAsLong(long l, long l1) {
    return l + l1;
  }
}
