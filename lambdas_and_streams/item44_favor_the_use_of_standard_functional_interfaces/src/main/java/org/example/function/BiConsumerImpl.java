package org.example.function;

import java.util.Date;
import java.util.function.BiConsumer;

//BiConsumer accepts to object and returns void
// Considering operates via side effects
public class BiConsumerImpl implements BiConsumer<String, Date> {

  @Override
  public void accept(String s, Date date) {
    date.setTime(Date.parse(s));
  }
}
