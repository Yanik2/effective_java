package org.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }

  //on every call of this method you have to check return value for null
  // it's ugly and it makes clients code more complicated
  private static Collection<String> collectionOrNull(String[] args) {
    return args.length == 0 ? null : Arrays.asList(args);
  }

  //proper way
  private static Collection<String> collection(String[] args) {
    return args.length == 0 ? Collections.emptyList() : Arrays.asList(args);
  }
}