package org.example;

import java.util.List;
import java.util.stream.IntStream;
import org.example.anagram.Anagram;
import org.example.cards.Deck;

//In the absence of explicit types, careful naming of lambda paramteres is essential
// to the readability of stream pipelines
public class Main {
  public static void main(String[] args) {
    final var list = List.of("qwer", "rewq", "wqer", "asdf", "fdsa", "dfsa", "zxcv", "vcxz");

    final var an = new Anagram();
    an.printAnagram(list, 2);

    System.out.println("===============");

    final var deck = new Deck();
    final var cards1 = deck.getDeck();
    final var cards2 = deck.getDeckStreams();

    System.out.println("card1: " + cards1);
    System.out.println("card2: " + cards2);
  }
}