package org.example;

//if you need to use lazy initialization for performance on an instance field, use double-ckeck idiom
// this idiom avoids the cost of locking when accessing the field after initialization
public class DoubleCheckIdiom {
  private volatile String field;

  public String getField() {
    String result = field;
    if (result != null) {
      return result;
    }

    synchronized (this) {
      if (field == null) {
        field = result = computeField();
      }
    }

    return result;
  }

  private String computeField() {
    return "field;";
  }
}
