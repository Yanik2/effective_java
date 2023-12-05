package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    final var map1 = createMapWithSideEffect(List.of("asdf", "asdf", "qwer", "zxcv"));
    final var map2 = createMapWithoutSideEffect(List.of("asdf", "asdf", "qwer", "zxcv"));

    System.out.println(map1);
    System.out.println(map2);
  }

  //This approach is not perfect, cause it uses forEach not as pure function
  //and as side effect it filling map
  public static Map<String, Long> createMapWithSideEffect(List<String> words) {
    final var map  = new HashMap<String, Long>();

    words.forEach(w -> {
      map.merge(w, 1L, Long::sum);
    });

    return map;
  }

  //Creates map with pure function without side effects
  public static Map<String, Long> createMapWithoutSideEffect(List<String> words) {
    return words.stream()
        .collect(Collectors.groupingBy(
            w -> w,
            Collectors.counting()
        ));
  }
}