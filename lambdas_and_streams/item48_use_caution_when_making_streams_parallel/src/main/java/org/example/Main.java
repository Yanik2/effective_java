package org.example;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

import java.math.BigInteger;
import java.util.stream.LongStream;
import java.util.stream.Stream;

//The best terminal operations for parallelism are reductions
// where all elements from stream reduced to one using one of STream's reduce methods
// min, max, count, anyMatch, allMatch, noneMatch also goog
// collect is not good because combining collections is very costly
//in summary use parallel() if you are 100% sure that it helps and won't break anything
public class Main {
  public static void main(String[] args) {
    var start = System.currentTimeMillis();
    primes();
    var end = System.currentTimeMillis();

    System.out.println("Sequential: " + (end - start));

    start = System.currentTimeMillis();
//    primesParallel();
    end = System.currentTimeMillis();

    System.out.println("Parallel: " + (end - start));

    start = System.currentTimeMillis();
    pi(1000000);
    end = System.currentTimeMillis();
    System.out.println("pi: " + (end - start));

    start = System.currentTimeMillis();
    parallelPi(1000000);
    end = System.currentTimeMillis();
    System.out.println("pi: " + (end - start));
  }

  private static void primes() {
    Stream.iterate(TWO, BigInteger::nextProbablePrime)
        .map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
        .filter(mersenne -> mersenne.isProbablePrime(50))
        .limit(20)
        .forEach(System.out::println);
  }

  //just freezes with 100% cpu usage
  // don't use parallel() on iterate() and on limit()
  private static void primesParallel() {
    Stream.iterate(TWO, BigInteger::nextProbablePrime)
        .parallel()
        .map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
        .filter(mersenne -> mersenne.isProbablePrime(50))
        .limit(20)
        .forEach(System.out::println);
  }

  private static long pi(long n) {
    return LongStream.rangeClosed(2, n)
        .mapToObj(BigInteger::valueOf)
        .filter(i -> i.isProbablePrime(50))
        .count();
  }

  //it works 4 times faster then sequential pi()
  private static long parallelPi(long n) {
    return LongStream.rangeClosed(2, n)
        .parallel()
        .mapToObj(BigInteger::valueOf)
        .filter(i -> i.isProbablePrime(50))
        .count();
  }
}