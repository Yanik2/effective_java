package org.example.function;

import java.util.function.ObjLongConsumer;

//Represents consumer that accepts two values, first parameterized type value, second int value
//It's important to use this interface in favor of standard BiConsumer when dealing with
//primitive types cause it can have significant impact on performance
public class ObjLongConsumerImpl implements ObjLongConsumer<String> {
  @Override
  public void accept(String s, long l) {
    System.out.println(s + l);
  }
}
