package org.example;

//if you need to use lazy initialization for performance on a static field, use the lazy initialization holder class
// idiom
//This idiom exploits the guarantee that a class will not be initialized until it is used
public class FieldHolderIdiom {
  private static class FieldHolder {
    static String field = computeFieldValue();

    private static String computeFieldValue() {
      if (0 < System.currentTimeMillis()) {
        return "more";
      } else {
        return "less";
      }
    }
  }

  public static String getField() {
    return FieldHolder.field;
  }
}
