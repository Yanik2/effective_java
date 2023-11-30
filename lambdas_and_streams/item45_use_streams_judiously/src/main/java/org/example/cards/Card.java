package org.example.cards;

public class Card {
  private Rank rank;
  private Suite suite;

  public Card(Rank rank, Suite suite) {
    this.rank = rank;
    this.suite = suite;
  }

  public Rank getRank() {
    return rank;
  }

  public void setRank(Rank rank) {
    this.rank = rank;
  }

  public Suite getSuite() {
    return suite;
  }

  public void setSuite(Suite suite) {
    this.suite = suite;
  }

  @Override
  public String toString() {
    return "Card{" +
        "rank=" + rank +
        ", suite=" + suite +
        '}';
  }
}
