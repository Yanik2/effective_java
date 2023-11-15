package org.example.stack;

public class Stack<E> {
  private E[] values;
  private int size;
  private int capacity;

  public Stack() {
    this.capacity = 8;
    this.size = 0;
    @SuppressWarnings("unchecked")
    E[] arr = (E[]) new Object[capacity];
    this.values = arr;
  }

  public void push(E o) {
    if (size == capacity)
      increaseCapacity();

    values[size++] = o;
  }

  public E pop() {
    if (isEmpty())
      throw new RuntimeException("Stack is empty");

    final var val = values[size - 1];
    values[size - 1] = null;
    size--;
    return val;
  }

  //Also you can use Object[] instead of E[] and cast objects before returning
//  public E pop() {
//    if (isEmpty())
//      throw new RuntimeException("Stack is empty");
//
//    final var val = (E) values[size - 1];
//    values[size - 1] = null;
//    size--;
//    return val;
//  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public int size() {
    return this.size;
  }

  public int capacity() {
    return this.capacity;
  }

  private void increaseCapacity() {
    @SuppressWarnings("unchecked")
    final var newArr = (E[]) new Object[capacity * 2];

    for (int i = 0; i < size; i++) {
      newArr[i] = values[i];
    }

    newArr[size] = null;
    this.values = newArr;
    this.capacity *= 2;
  }
}
