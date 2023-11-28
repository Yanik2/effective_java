package org.example.function;

import java.util.function.Supplier;

//Represents supplier that takes no arguments and produces value of paramterized type
public class SupplierImpl implements Supplier<String> {
  @Override
  public String get() {
    return "hello";
  }
}
