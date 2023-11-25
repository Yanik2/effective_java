package org.example;

import org.example.annotation.ExceptionArrayTest;
import org.example.annotation.ExceptionTest;
import org.example.annotation.ExceptionTestRepeatable;
import org.example.annotation.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;

        final var testClass = Class.forName("org.example.test.TestClass");

        //@Test annotation processor
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
        testWithArrayException();
        testRepeatableAnnotation();
    }

//@ExceptionTest annotation processor
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

//    @ExceptionArrayTest annotation processor
    private static void testWithArrayException() throws ClassNotFoundException {
        final var testClass = Class.forName("org.example.test.ExceptionArrayTestClass");

        int tests = 0;
        int passed = 0;

        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionArrayTest.class)) {
                final var annotation = m.getAnnotation(ExceptionArrayTest.class);
                final var expectedExceptions = new HashSet<>(Arrays.asList(annotation.value()));
                tests++;

                try {
                    m.invoke(null);
                } catch (InvocationTargetException e) {
                    final var exClass = e.getCause().getClass();
                    if (expectedExceptions.contains(exClass)) {
                        passed++;
                        System.out.println("Test passed: " + m.getName());
                    } else {
                        System.out.println("Test not passed, unexpected exception, expected on of " + expectedExceptions + ", but was: " + e.getCause());
                    }
                } catch (Exception e) {
                    System.out.println("Unexpected exception: + " + e);
                }
            }
        }
    }

    //@ExceptionTestRepeatable annotation processor
    private static void testRepeatableAnnotation() throws ClassNotFoundException {
        int passed = 0;
        int tests = 0;

        final var testClass = Class.forName("org.example.test.ExceptionTestRepeatableClass");

        for (Method m: testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionTestRepeatable.class)
                    || m.isAnnotationPresent(ExceptionTestRepeatable.MyContainer.class)) {
                final var expectedExceptions = Arrays.stream(m.getAnnotationsByType(ExceptionTestRepeatable.class))
                        .map(ExceptionTestRepeatable::value)
                        .collect(Collectors.toSet());
                tests++;

                try {
                    m.invoke(null);
                } catch (InvocationTargetException e) {
                    final var exClass = e.getCause().getClass();
                    if (expectedExceptions.contains(exClass)) {
                        System.out.println("Test method " + m + " has passed");
                        passed++;
                    } else {
                        System.out.println("Test method " + m + " failed, wrong exception: " + e.getCause());
                    }
                } catch (Exception e) {
                    System.out.println("Unexpected exception in method: " + m + " exception: " + e.getCause());
                }

            }
        }
    }
}