package org.example.container;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Favorites {
  private Map<Class<?>, Object> values;
  public <T> void put(Class<T> key, T value) {
    this.values.put(key, value);
  }

  public <T> T get(Class<T> key) {
    return key.cast(this.values.get(key));
  }
}
