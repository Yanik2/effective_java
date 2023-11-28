package org.example.function;

import java.util.function.DoubleConsumer;

//Represents consumer that accepts as argument double value
// It's important to use this interface in case of dealing with unboxed primitive types
// cause it can have significant impact on performance
public class DoubleConsumerImpl implements DoubleConsumer {
  @Override
  public void accept(double v) {
    System.out.println(v);
  }
}
