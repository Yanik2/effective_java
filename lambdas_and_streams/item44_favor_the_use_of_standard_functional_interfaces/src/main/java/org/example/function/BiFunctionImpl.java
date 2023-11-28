package org.example.function;

import java.math.BigInteger;
import java.util.function.BiFunction;

//Represents a function that accepts two arguments and produces a result
// parameterized by 3 parameter types, 2 accept, third return type
public class BiFunctionImpl implements BiFunction<String, Integer, BigInteger> {
  @Override
  public BigInteger apply(String s, Integer integer) {
    final var bigInt = s + integer;
    return new BigInteger(bigInt);
  }
}
