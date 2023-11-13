package org.example;

public class ParameterizedClass<E> {
  private E value;

  public ParameterizedClass(E value) {
    this.value = value;
  }

  public E getValue() {
    return value;
  }

  public void setValue(E value) {
    this.value = value;
  }

  public <T> T[] toArray(T[] a) {
    @SuppressWarnings("unchecked") T casted = (T) value;
    a[0] = casted;
    return a;
  }
}
