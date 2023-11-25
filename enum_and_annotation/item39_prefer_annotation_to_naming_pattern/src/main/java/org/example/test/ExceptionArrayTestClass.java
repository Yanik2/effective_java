package org.example.test;

import org.example.annotation.ExceptionArrayTest;

public class ExceptionArrayTestClass {
    @ExceptionArrayTest({IndexOutOfBoundsException.class, NullPointerException.class})
    public static void test1() {
        throw new IndexOutOfBoundsException();
    }

    @ExceptionArrayTest({IndexOutOfBoundsException.class, NullPointerException.class})
    public static void test2() {
        throw new NullPointerException();
    }

    @ExceptionArrayTest({ArithmeticException.class})
    public static void test3() {
        throw new NullPointerException();
    }
}
