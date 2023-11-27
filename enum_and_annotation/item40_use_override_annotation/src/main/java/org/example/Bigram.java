package org.example;

import java.util.HashSet;

public class Bigram {
  private final char first;
  private final char second;

  public Bigram(char first, char second) {
    this.first = first;
    this.second = second;
  }

  //Compiler error, method does not override method from superclass
  //Always use @Override annotation, it will help you catch this kind of errors on compile stage
  // and prevent unpredictable behaviour
//  @Override
  public boolean equals(Bigram bigram) {
    return bigram.first == this.first && bigram.second == this.second;
  }

  public int hashCode() {
    return 31 * first + second;
  }

  public static void main(String[] args) {
    final var set = new HashSet<Bigram>();

    for (int i = 0; i < 10; i++) {
      for (char c = 'a'; c <= 'z'; c++) {
        set.add(new Bigram(c, c));
      }
    }

    //Set size will be 260, which is not expected size
    //it happens because of invalid implementation of equals method
    System.out.println(set.size());
  }
}
