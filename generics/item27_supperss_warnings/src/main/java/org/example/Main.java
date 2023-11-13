package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    final var param = new ParameterizedClass<>("jim");
    //Array store exception, must be given proper array type
//    Integer[] intArr = new Integer[1];
//    final var arr = param.toArray(intArr);

    String[] strArr = new String[1];
    final var arr = param.toArray(strArr);
  }
}