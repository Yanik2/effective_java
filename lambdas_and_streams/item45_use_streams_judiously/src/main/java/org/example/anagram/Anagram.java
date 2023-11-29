package org.example.anagram;

import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

//In the absence of explicit types, careful naming of lambda paramteres is essential
// to the readability of stream pipelines

//Using helper methods is even more important for readability in stream pipelines than in
//iterative code
public class Anagram {

  public void printAnagram(List<String> words, int maxSize) {
    final var map = new HashMap<String, Set<String>>();

    for (String s : words) {
      map.computeIfAbsent(alphabetize(s), key -> new TreeSet<>()).add(s);
    }

    for (Set<String> set : map.values()) {
      if (set.size() <= maxSize) {
        System.out.println("Anagram set size: " + set.size() + " values: " + set);
      }
    }
  }

  //It could be done via stream, but you should refrain from using streams to process
  //char values, cause there is not char stream, and it would be converted to IntStream
  // then youd need to cast it
  private String alphabetize(String str) {
    final var arr = str.toCharArray();
    Arrays.sort(arr);
    return new String(arr);
  }

  //Don't overuse streams cause it's hard to read and understand
  public void printAnagramsAllStreamImpl(List<String> words, int maxSize) {
    words.stream()
        .collect(groupingBy(
            str -> str.chars().sorted()
                .collect(
                () -> {
                  final var sb = new StringBuilder();
                  return sb;
                },
                (sb, c) -> {
                  sb.append((char) c);
                },
                (sb1, sb2) -> {
                  sb1.append(sb2);
                }
            ).toString(),
            Collectors.toSet()
        ))
        .values()
        .stream()
        .filter(set -> set.size() <= maxSize)
        .forEach(System.out::println);
  }

  //Fine usage of streams, easy to read
  public void printAnagramsGoodStreamImpl(List<String> words, int maxSize) {
    words.stream()
        .collect(groupingBy(this::alphabetize))
        .values()
        .stream()
        .filter(set -> set.size() <= maxSize)
        .forEach(set -> System.out.println("set size: " + set.size() + " values: " + set));
  }
}
