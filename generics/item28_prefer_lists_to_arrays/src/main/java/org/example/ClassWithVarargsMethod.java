package org.example;

public class ClassWithVarargsMethod<E> {

// Compiler warning Possible heap pollution from parameterized vararg type
  // Warning can be ignored with @SafeVararg annotation
  public void testVarargs(E... args) {

  }
}
