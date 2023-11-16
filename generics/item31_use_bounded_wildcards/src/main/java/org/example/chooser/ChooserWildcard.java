package org.example.chooser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ChooserWildcard<E> {
  private List<E> values;

  //see item 28 Chooser
  //use wildcard then you can put Collection<Integetr> in chooser which
  //paramterized with <Number>
  public ChooserWildcard(Collection<? extends E> values) {
    this.values = new ArrayList<>(values);
  }
}
