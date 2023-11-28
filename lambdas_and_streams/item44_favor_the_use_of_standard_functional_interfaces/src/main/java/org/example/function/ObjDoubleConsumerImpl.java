package org.example.function;

import java.util.function.ObjDoubleConsumer;

//Represents consumer that accepts two values, first parameterized type value, second double value
//It's important to use this interface in favor of standard BiConsumer when dealing with
//primitive types cause it can have significant impact on performance
public class ObjDoubleConsumerImpl implements ObjDoubleConsumer<String> {
  @Override
  public void accept(String s, double v) {
    System.out.println(s + v);
  }
}
