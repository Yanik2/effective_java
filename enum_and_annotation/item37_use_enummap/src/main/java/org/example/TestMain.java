package org.example;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Function;

public class TestMain {
  public static void main(String[] args) {
    final var users = List.of(new User("jim"), new User("pam"), new User("jim"), new User("pam"), new User("andy"));

    final var map1 = users.stream().collect(groupingBy(u -> u.getName()));

    final var map2 = users.stream().collect(groupingBy(u -> u.getName(), toSet()));

    final var map3 = users.stream().collect(groupingBy(u -> u.getName(), () -> new TreeMap<>(), toSet()));

    final var map4 = users.stream().collect(toMap(
        u -> u.getName(),
        Function.identity(),
        (x, y) -> new User(x.getName() + " " + y.getName()),
        () -> new HashMap<>()
    ));

    users.size();
  }
}
