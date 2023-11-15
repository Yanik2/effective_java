package org.example.function;

import java.util.function.UnaryOperator;

public class UnaryOperatorImpl<T> implements UnaryOperator<T> {
  @Override
  public T apply(T t) {
    return t;
  }
}
