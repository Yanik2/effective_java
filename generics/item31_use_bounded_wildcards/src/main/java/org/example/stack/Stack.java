package org.example.stack;

import java.util.Collection;

public class Stack<E> {
  private Object[] values;
  private int capacity;
  private int size;

  public void push(E element) {
    if (size == capacity)
      increaseCapacity();

    values[size++] = element;
  }

  public E pop() {
    if (isEmpty())
      throw new RuntimeException("Stack is empty");

    return (E) values[--size];
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public void addAllWithoutWildcard(Iterable<E> values) {
    for (E value : values) {
      this.push(value);
    }
  }

  //producer - extends
  public void addAllWildcard(Iterable<? extends E> values) {
    for (E value : values) {
      this.push(value);
    }
  }

  //consumer - super
  public void popAll(Collection<? super E> coll) {
    while(!isEmpty()) {
      coll.add(this.pop());
    }
  }

  private int size() {
    return this.size;
  }

  private int capacity() {
    return this.capacity;
  }

  private void increaseCapacity() {
    final var newArr = new Object[capacity * 2];

    for (int i = 0; i < size; i++) {
      newArr[i] = values[i];
    }

    values = newArr;
    capacity *= 2;
  }
}
