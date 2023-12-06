package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
  public static void main(String[] args) {
    Collection<?>[] arr = {
       new HashSet<>(),
        new ArrayList<>(),
        new HashMap<>().values()
    };

    //overloading is decided at compile time, and at that time all types in arr is COllection
    //overriding on other hand works in runtime and the choice of which overriding to invoke
    // is made at runtime
    for (Collection<?> col : arr) {
      System.out.println(CollectionClassifier.classify(col));
    }
  }

  private static void overloadingThread() {
    new Thread(System.out::println).start();

    final var executor = Executors.newCachedThreadPool();
    //Compile time error
    //Reference to 'println' is ambiguous, both 'println()' and 'println(boolean)' match
    executor.submit(System.out::println);
  }
}