package org.example;

import java.sql.SQLOutput;

public class Main {
  private static Integer i;

  public static void main(String[] args) {
    final var int1 = new Integer(42);
    final var int2 = new Integer(42);

    //prints false
    System.out.println(int1 == int2);

    //throws NullPointerException
//    System.out.println(i == 42);

    final var start = System.currentTimeMillis();
    // time of execution with Object ~ 5300
//    Long l = 0L;
    // time of execution with primitive type ~ 500
    long l = 0;
    for (int i = 0; i < Integer.MAX_VALUE; i++) {
      l += i;
    }

    final var end = System.currentTimeMillis();

    System.out.println(end - start);
  }
}