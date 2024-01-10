package org.example;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
  private static boolean isFinished;
  private static volatile boolean volatileFinished;
  private static volatile int nextSerialNumber = 0;
  private static AtomicInteger atomicInt = new AtomicInteger();

  private static synchronized void requestStop() {
    isFinished = true;
  }

  private static synchronized boolean isStopped() {
    return isFinished;
  }

  public static void main(String[] args) throws InterruptedException {
//    notSynchronized();
//    synchronizedMethod();
    volatileMethod();
  }

  //this program never stops, because there is not guarantee that background thread will ever see changes
  //in isFinished field. Without synchronization for the virtual machine is acceptable to make this code like:
  // if (!isFinished) { while(true) { i++ }}
  private static void notSynchronized() throws InterruptedException {
    final var thread = new Thread(() -> {
      int i = 0;
      while(!isFinished) {
        i++;
      }
      System.out.println(i);
    });

    thread.start();
    TimeUnit.SECONDS.sleep(1);
    isFinished = true;
  }

  //method stops execution in about one second because of synchronized access to isFinished
  private static void synchronizedMethod() throws InterruptedException {
    final var thread = new Thread(() -> {
      int i = 0;
      while(!isStopped()) {
        i++;
      }
      System.out.println(i);
    });

    thread.start();

    TimeUnit.SECONDS.sleep(1);
    requestStop();
  }

  //also works
  private static void volatileMethod() throws InterruptedException {
    final var thread = new Thread(() -> {
      int i = 0;
      while(!volatileFinished) {
        i++;
      }
      System.out.println(i);
    });
    thread.start();
    TimeUnit.SECONDS.sleep(1);
    volatileFinished = true;
  }

  //this method wouldn't work correctly because nextSerialNumber is not synchronized
  // one of the way to make it work is make it synchronized or make it atomic
  private static int getNextSerialNumber() {
    return nextSerialNumber++;
  }

  //will work without synchronization
  private static int getNextAtomic() {
    return atomicInt.getAndIncrement();
  }
}