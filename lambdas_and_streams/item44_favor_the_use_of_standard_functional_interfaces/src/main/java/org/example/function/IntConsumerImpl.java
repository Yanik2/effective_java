package org.example.function;

import java.util.function.IntConsumer;

//Represents consumer that consumes one argument of type int, no return value
// It's important to use this interface in favor of standard Consumer when dealing with
// primitive unboxed types cause it can have significant impact on performance
public class IntConsumerImpl implements IntConsumer {
  @Override
  public void accept(int i) {

  }
}
