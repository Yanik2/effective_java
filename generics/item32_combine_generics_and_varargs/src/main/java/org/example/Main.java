package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<String> strs = new ArrayList<>();
    strs.add("asdf");
    List<String> strs2 = new ArrayList<>();
    strs2.add("asdfasdf");
    method(strs, strs2);
  }

  //Warning: 'Possible heap pollution from parameterized vararg type
  //@SafeVarargs annotation can be used only when method doesn't store anything in varargs array
  // and doesn't allow a reference to array to escape, which would allow untrusted code to
  //mutate array then you can consider it safe and user @SafeVarargs annotation
  //Runtime class cast exception
  private static void method(List<String>... lists) {
    List<Integer> ints = new ArrayList<>();
    ints.add(1);
    Object[] obj = lists;
    obj[1] = ints;
    String str = lists[1].get(0);
  }

  //@SafeVarargs annotation can be used
}