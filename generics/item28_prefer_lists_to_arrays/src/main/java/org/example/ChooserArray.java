package org.example;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ChooserArray {
  private Object[] values;

  public ChooserArray(Collection coll) {
    this.values = coll.toArray();
  }

  //Need to cast return value every time
  public Object getRandomValue() {
    final var random = ThreadLocalRandom.current();
    return values[random.nextInt(values.length)];
  }
}
