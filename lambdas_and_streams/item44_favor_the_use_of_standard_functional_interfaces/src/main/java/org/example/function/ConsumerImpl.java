package org.example.function;


import java.util.function.Consumer;

//Represents consumer function that accepts one argument and returns no result
// Expected operates via side effects
public class ConsumerImpl implements Consumer<String> {
  @Override
  public void accept(String s) {
    System.out.println(s);
  }
}
