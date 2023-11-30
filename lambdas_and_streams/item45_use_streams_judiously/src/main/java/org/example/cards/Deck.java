package org.example.cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deck {

  public List<Card> getDeck() {
    final var deck = new ArrayList();

    for (Rank r : Rank.values()) {
      for (Suite s : Suite.values()) {
        deck.add(new Card(r, s));
      }
    }

    return deck;
  }

  public List<Card> getDeckStreams() {
    return Arrays.stream(Rank.values())
        .flatMap(r -> Arrays.stream(Suite.values())
            .map(s -> new Card(r, s)))
        .toList();
  }
}
