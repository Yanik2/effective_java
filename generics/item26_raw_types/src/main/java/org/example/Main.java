package org.example;

import java.util.List;
import org.example.generics.ParameterizedClass;
import org.example.model.User;

public class Main {
  public static void main(String[] args) {
    final var user = new User("jim", 32);

    final var obj = new ParameterizedClass<>("value");

    unsafeOperation(obj, user);
//  ClassCastException
//    final var objValue = obj.getParameterizedValue();

    final var obj2 = new ParameterizedClass<>("value");
    // Compile error "cannot be applied"
//    error at compile time safer
//    safeOperationWithObjectParameterized(obj2, user);
  }

  private static void unsafeOperation(ParameterizedClass param, Object value) {
    param.setParameterizedValue(value);
  }

  private static void safeOperationWithWildcard(ParameterizedClass<?> param, Object value) {
    // Compilation error, much safer, error on compile time
//    You cannot put element other than null into ParameterizedClass<?>
//    param.setParameterizedValue(value);
  }

  private static void safeOperationWithObjectParameterized(ParameterizedClass<Object> obj,
                                                           Object value) {
    obj.setParameterizedValue(value);
  }

  private static void instanceOfUsage(Object obj) {
//    Compiler error, unsafe cast to ParameterizedClass<String>
//    if (obj instanceof ParameterizedClass<String>)

//    Safe cast
    if (obj instanceof ParameterizedClass<?>) {
      System.out.println(obj);
    }
  }
}