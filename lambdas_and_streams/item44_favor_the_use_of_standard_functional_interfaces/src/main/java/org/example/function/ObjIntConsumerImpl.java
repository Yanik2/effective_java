package org.example.function;

import java.util.function.ObjIntConsumer;

//Represents consumer that accepts two values, first parameterized type value, second int value
//It's important to use this interface in favor of standard BiConsumer when dealing with
//primitive types cause it can have significant impact on performance
public class ObjIntConsumerImpl implements ObjIntConsumer<String> {
  @Override
  public void accept(String s, int i) {
    System.out.println(s + i);
  }
}
