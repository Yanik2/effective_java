package org.example.generics;

public class ParameterizedClass<E> {
  private E parameterizedValue;

  public ParameterizedClass(E parameterizedValue) {
    this.parameterizedValue = parameterizedValue;
  }

  public E getParameterizedValue() {
    return parameterizedValue;
  }

  public void setParameterizedValue(E parameterizedValue) {
    this.parameterizedValue = parameterizedValue;
  }
}
