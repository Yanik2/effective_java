package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.example.stack.Stack;

public class Main {
  public static void main(String[] args) {
    List<Integer> ints = new ArrayList<>();
    Stack<Number> stack = new Stack<>();
    //compiler error, because generics are invariant
    // it means that List<Integer> is not a subtype of List<Number>,
    //so you cannot pass argument List<Integer> to method where expecting List<Number>
//    stack.addAllWithoutWildcard(ints);

    //Compiles just fine cause method is parameterized with wildcard <? extends E>
    //it means that this method can accept any List which paramterized type is
    //extends Stacks parameterized type
    stack.addAllWildcard(ints);

    final var setInts = new HashSet<Integer>();
    final var setDoubles = new HashSet<Double>();
    Set<Number> unionSet = union(setInts, setDoubles);

    unionSet.size();
  }

  //do not use wildcard as return type
  public static <E> Set<E> union(Set<? extends E> o1, Set<? extends E> o2) {
    final var newSet = new HashSet<E>();
    newSet.addAll(o1);
    newSet.addAll(o2);
    return newSet;
  }

  //Compile error, because you cannot put in parameterized with wildcard anything except null
  //
  public static void swap(List<?> list, int i, int j) {
    list.set(i, list.set(j, list.get(i)));
  }

  public static void swapWithHelp(List<?> list, int i , int j) {
    swapHelper(list, i, j);
  }

  //No error because compilers knows type, knows that anything we get from list of E is a type of E
  // and we can put anything of type E in the list
  private static <E> void swapHelper(List<E> list, int i, int j) {
    list.set(i, list.set(j, list.get(i)));
  }
}