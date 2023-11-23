package org.example;

import org.example.annotation.ExceptionTest;
import org.example.annotation.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;

        final var testClass = Class.forName("org.example.test.TestClass");

        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                }  catch (InvocationTargetException e) {
                    System.out.println("Exception was throws from: " + m + " exception: " + e.getCause());
//                    throw new RuntimeException(e);
                } catch (Exception e) {
                    System.out.println("invalid test: " + m);
                }

            }
        }
        System.out.println("Passed from @Test: " + passed);

        testsWithException();
    }

    private static void testsWithException() throws ClassNotFoundException {
        final var testClass = Class.forName("org.example.test.ExceptionTestClass");

        int tests = 0;
        int passed = 0;
        for (Method m : testClass.getMethods()) {
            if (m.isAnnotationPresent(ExceptionTest.class)) {
                final var exception = m.getAnnotation(ExceptionTest.class).value();
                tests++;
                try {
                    m.invoke(null);
                    System.out.println("Test failed, no exception in method: " + m);
                } catch (InvocationTargetException e) {
                    if (exception.isInstance(e.getCause())) {
                        System.out.println("Test: " + m + " passed");
                        passed++;
                    } else {
                        System.out.println("Test has not passed, wrong exception: " + e.getCause());
                    }
                } catch (Exception e) {
                    System.out.println();
                }
            }
        }

        System.out.println("ExceptionTestClass tests passed: " + passed);
    }
}