package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

//All this try/catch and exceptions could be avoided if use just normal instantiations,
//cause all of this would be caught on compile-time
//Using reflection has that disadvantage that you lost compile-time safety and all errors that could could be seen
// in compile-time become runtime errors
public class Main {
  public static void main(String[] args) {
    Class<? extends Set<String>> clazz = null;
    try {
      clazz = (Class<? extends Set<String>>) Class.forName(args[0]);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }

    Constructor<? extends Set<String>> cons = null;
    try {
      cons = clazz.getDeclaredConstructor();
    } catch (NoSuchMethodException e) {
      throw new RuntimeException(e);
    }

    Set<String> set = null;
    try {
      set = cons.newInstance();
    } catch (InstantiationException e) {
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    } catch (InvocationTargetException e) {
      throw new RuntimeException(e);
    }

    set.addAll(Arrays.asList(args).subList(1, args.length));
  }
}