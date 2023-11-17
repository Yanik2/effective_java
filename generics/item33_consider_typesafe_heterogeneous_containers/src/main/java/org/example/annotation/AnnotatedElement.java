package org.example.annotation;

import java.lang.annotation.Annotation;

public class AnnotatedElement {
  private Annotation annotation;

  public <T extends Annotation> T getAnnotation(Class<T> annotationType) {
    return (T) this.annotation;
  }
}
