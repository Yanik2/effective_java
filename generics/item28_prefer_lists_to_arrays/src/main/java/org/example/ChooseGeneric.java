package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

// This version a tad more verbose and perhaps a tad slower, but it's worth
// because you get rid of unexpected runtime ClassCastException
public class ChooseGeneric<T> {
  private final List<T> values;

  public ChooseGeneric(Collection<T> coll) {
    this.values = new ArrayList<>(coll);
  }

  public T getRandomValue() {
    final var random = ThreadLocalRandom.current();
    return values.get(random.nextInt(values.size()));
  }
}
