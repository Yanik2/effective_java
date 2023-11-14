package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    //RUntime exception ArrayStoreException
    Object[] obj = new Integer[10];
    obj[0] = "hello";

    List<String> list = new ArrayList<>();
    //Compiler error
//    test(list);
  }

  private static void test(List<Object> list) {

  }

  //Wont compile
  private static void genericArrayWontCompile() {
    //COmpile error
//    List<String>[] strLIsts = new ArrayList<String>[1];
//    List<Integer> ints = List.of(42);
//    Object[] arr = strLIsts;
//    arr[0] = ints;
    //Could be runtime ClassCastException, but this method wont compile
//    String str = strLIsts[0].get(0);
  }
}