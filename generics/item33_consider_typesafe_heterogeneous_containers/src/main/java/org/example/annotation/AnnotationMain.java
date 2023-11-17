package org.example.annotation;

import java.lang.annotation.Annotation;

public class AnnotationMain {
  public static void main(String[] args) {

  }

  private static Annotation getAnnotation(AnnotatedElement el, String className)
      throws ClassNotFoundException {
    Class<?> annotationType = Class.forName(className);

    return el.getAnnotation(annotationType.asSubclass(Annotation.class));
  }
}
