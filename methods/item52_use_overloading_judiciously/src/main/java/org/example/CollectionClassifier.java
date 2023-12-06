package org.example;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class CollectionClassifier {
  public static String classify(Set<?> set) {
    return "Set";
  }

  public static String classify(List<?> list) {
    return "List";
  }

  //overloading are decided at compile time
  public static String classify(Collection<?> collection) {
    return "Unknown collection";
  }
}
