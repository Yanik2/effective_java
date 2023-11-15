package org.example.function;

import java.util.function.Function;

public  class FunctionImpl<E> implements Function<E, E> {

  @Override
  public E apply(E e) {
    return e;
  }
}
