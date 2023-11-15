package org.example;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class Main {
  public static void main(String[] args) {
    final var set1 = new HashSet<String>();
    set1.add("asdf");
    final var set2 = new HashSet<Integer>();
    set2.add(1);

    //No compile time error, no runtime error
    final var resultFromNonParameterized = unionNotParameterized(set1, set2);
    //Runtime ClassCastException, because set of strings was unioned with set of integers
    // in not parameterized method
    for (Object o : resultFromNonParameterized) {
      String s = (String) o;
    }

    //Compile error, because method is parameterized and you cannot just put there two
    //coollections parameterized by different types
//    unionParameterized(set1, set2);

    final var result = someComparator("asdf", "asdf");
    System.out.println(result);
  }

  //Generates warnings
  //Raw use of parameterized Set
  //Unchecked call to HashSet(Collection<? extends E>)
  //Unchecked call to addAll(Collection<? extends E>)
  public static Set unionNotParameterized(Set o1, Set o2) {
    final var result = new HashSet(o1);
    result.addAll(o2);
    return result;
  }

  //This method doesn't have warning and provide type safety
  public static <E> Set<E> unionParameterized(Set<E> o1, Set<E> o2) {
    final var result = new HashSet<>(o1);
    result.addAll(o2);
    return result;
  }

  public static <E extends Comparable<E>> E someComparator(E o1, E o2) {
    return o1 == o2 ? o1 : o2;
  }
}