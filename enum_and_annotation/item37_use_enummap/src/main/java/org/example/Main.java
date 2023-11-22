package org.example;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.example.enummap.LifeCycle;
import org.example.enummap.Plant;

//It is rarely appropriate to use ordinals to index into arrays; use EnumMap instead
public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }

  //very complicated implementation of grouping plants by lifecycle in array
  public static Set<Plant>[] plantsInArray(List<Plant> garden) {
    final Set<Plant>[] plants = (Set<Plant>[]) new Set[LifeCycle.values().length];

    for(int i = 0; i < plants.length; i++) {
      plants[i] = new HashSet<>();
    }

    garden.forEach(g -> plants[g.lifeCycle().ordinal()].add(g));

    return plants;
  }

  //Much understandable method, and much safe
  //Here is no unsafe cast
  //Performance of this map is very close to array approach, because it uses Enum oriented implementation
  public static Map<LifeCycle, Set<Plant>> plantsInMap(List<Plant> garden) {
    Map<LifeCycle, Set<Plant>> plants = new EnumMap<>(LifeCycle.class);
    for (LifeCycle lc : LifeCycle.values()) {
      plants.put(lc, new HashSet<>());
    }

    garden.forEach(p -> plants.get(p.lifeCycle()).add(p));

    return plants;
  }

  public static Map<LifeCycle, Set<Plant>> plantsImMapStream(List<Plant> garden) {
    return garden.stream()
        .collect(groupingBy(
            p -> p.lifeCycle(),
            () -> new EnumMap<>(LifeCycle.class),
            toSet()));
  }

}