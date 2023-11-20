package org.example;

import java.util.EnumSet;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    //just because an enumerated type will be used in sets,
    //there is no reason to represent it with bit fields
    //be aware EnumSet.of() return mutable set
    //if you need immutable you can wrap it in Collections.unmodifiableSet or use just Set.of(),
    // but performance will suffer
    final var immutableSet = Set.of(Style.BOLD);
    final var enumSet = EnumSet.of(Style.BOLD, Style.ITALIC);
    enumSet.add(Style.STRIKETHROUGH);
    System.out.println("Hello world!");
  }
}