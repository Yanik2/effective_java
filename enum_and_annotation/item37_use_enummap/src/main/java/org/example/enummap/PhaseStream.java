package org.example.enummap;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public enum PhaseStream {
  SOLID, LIQUID, GAS;

  public enum Transition {
    MELT(SOLID, LIQUID),
    FREEZE(LIQUID, SOLID),
    BOIL(LIQUID, GAS),
    CONDENSE(GAS, LIQUID),
    SUBLIME(SOLID, GAS),
    DEPOSIT(GAS, SOLID);

    public static final Map<PhaseStream, Map<PhaseStream, Transition>> m =
        Stream.of(values()).collect(groupingBy(
            transition -> transition.from,
            () -> new EnumMap<>(PhaseStream.class),
            toMap(
                transition -> transition.to,
                Function.identity(),
                (x, y) -> y,
                () -> new EnumMap<>(PhaseStream.class)
            )
        ));
    private final PhaseStream from;
    private final PhaseStream to;

    public PhaseStream getFrom() {
      return from;
    }

    public PhaseStream getTo() {
      return to;
    }

    Transition(PhaseStream from, PhaseStream to) {
      this.from = from;
      this.to = to;
    }
  }
}
