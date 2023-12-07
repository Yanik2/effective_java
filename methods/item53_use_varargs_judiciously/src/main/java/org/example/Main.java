package org.example;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }

  //bad implementation
  //check for size, throws exception
  //if not exception than you should initialize min with Integer.MIN_VALUE which is not really good
  private static int min(int ... values) {
    if (values.length == 0)
      throw new IllegalArgumentException();

    int min = values[0];

    for (int v : values) {
      if (v < min)
        min = v;
    }

    return min;
  }

  //much better, no check, no exception
  // just make first parameter and second varargs
  private static int min2(int firstValue, int ... values) {
    int min = firstValue;

    for (int v : values) {
      if (v < min)
        min = v;
    }

    return min;
  }
}