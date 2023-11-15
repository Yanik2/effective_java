import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.example.stack.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackTest {
  private Stack target;
  private Stack<String> parameterizedTarget;

  @BeforeEach
  void setUp() {
    target = new Stack();
    parameterizedTarget = new Stack<String>();
  }

  @Test
  void stackTest() {
    final var strings =
        List.of("asdf", "qwer", "zxcv", ";klj", "piup", "m,./", "ghk", "trew", "bvcx");


    Assertions.assertDoesNotThrow(() -> fillStack(strings));
    assertEquals(9, target.size());
    assertPop(strings);
    assertTrue(target.isEmpty());
    assertEquals(16, target.capacity());
    assertThrows(RuntimeException.class, () -> target.pop());
    target.push("asdf");
    assertThrows(ClassCastException.class, () -> {
      //Every time you pop from not parameterized stack you need to cast which can lead to
      // ClassCastException
      Integer value = (Integer) target.pop();
    });
  }

  @Test
  void parameterizedStackTest() {
    final var strings =
        List.of("asdf", "qwer", "zxcv", ";klj", "piup", "m,./", "ghk", "trew", "bvcx");


    Assertions.assertDoesNotThrow(() -> fillParameterizedStack(strings, parameterizedTarget));
    assertEquals(9, parameterizedTarget.size());
    assertParameterizedPop(strings, parameterizedTarget);
    assertTrue(parameterizedTarget.isEmpty());
    assertEquals(16, parameterizedTarget.capacity());
    assertThrows(RuntimeException.class, () -> parameterizedTarget.pop());
    parameterizedTarget.push("asdf");

    assertDoesNotThrow(() -> {
      //You don't need to cast return value from parameterized stack
      // which prevent unnecessary posiibility of ClassCastException
      String value = parameterizedTarget.pop();
    });

  }

  private void fillStack(List<String> values) {
    values.forEach(target::push);
  }

  private void fillParameterizedStack(List<String> values, Stack<String> stack) {
    values.forEach(stack::push);
  }

  private void assertPop(List<String> values) {
    for (int i = values.size() - 1; i >= 0; i--) {
      assertEquals(values.get(i), target.pop());
    }
  }

  private void assertParameterizedPop(List<String> values, Stack<String> stack) {
    for (int i = values.size() - 1; i >= 0; i--) {
      assertEquals(values.get(i), parameterizedTarget.pop());
    }
  }
}
