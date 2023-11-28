package org.example.function;

import java.util.function.LongConsumer;

//Represents consumer that consumes long argument and produces no values
// It's important to use this interface in favor of standard Consumer when dealing with
// primitive unboxed types cause it can have significant impact on performance
public class LongConsumerImpl implements LongConsumer {
  @Override
  public void accept(long l) {

  }
}
