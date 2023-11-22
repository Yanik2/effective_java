package org.example.enummap;

import java.util.EnumMap;
import javax.management.InstanceNotFoundException;

//Using ordinal() to index array of arrays - DON'T DO THIS!
public enum Phase {
  SOLID, LIQUID, GAS, PLASMA;

  public enum Transition {
    MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT, IONIZATION, DEIONIZATION;

    //Rows indexed by from-ordinal, cols by to-ordinal
    private static final Transition[][] TRANSITIONS = {
        { null, MELT, SUBLIME },
        { FREEZE, null, BOIL },
        { DEPOSIT, CONDENSE, null }
    };

    private static final EnumMap<Phase, EnumMap<Phase, Transition>> getTransitionsMap() {
        final var map = new EnumMap<Phase, EnumMap<Phase, Transition>>(Phase.class);
        var innerMap = new EnumMap<Phase, Transition>(Phase.class);
        innerMap.put(LIQUID, MELT);
        innerMap.put(GAS, SUBLIME);
        map.put(SOLID, innerMap);

        innerMap = new EnumMap<>(Phase.class);
        innerMap.put(SOLID, FREEZE);
        innerMap.put(GAS, BOIL);
        map.put(LIQUID, innerMap);

        innerMap = new EnumMap<>(Phase.class);
        innerMap.put(SOLID, DEPOSIT);
        innerMap.put(LIQUID, CONDENSE);
        innerMap.put(PLASMA, IONIZATION);
        map.put(GAS, innerMap);

        innerMap = new EnumMap<>(Phase.class);
        innerMap.put(GAS, DEIONIZATION);
        map.put(PLASMA, innerMap);

        return map;
    }

    //Returns the phase transition from one phase to another
    public static Transition from(Phase from, Phase to) {
      return TRANSITIONS[from.ordinal()][to.ordinal()];
    }
  }
}
