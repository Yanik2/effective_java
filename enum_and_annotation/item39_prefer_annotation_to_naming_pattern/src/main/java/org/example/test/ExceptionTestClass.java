package org.example.test;

import org.example.annotation.ExceptionTest;

public class ExceptionTestClass {
    //Should success, expected exception
    @ExceptionTest(ArithmeticException.class)
    public static void test1() {
        int i = 0;
        int j = i / i;
    }

    //Should fail wrong exception
    @ExceptionTest(ArithmeticException.class)
    public static void test2() {
        int[] i = new int[0];
        int j = i[1];
    }

    //Should fail, no exception
    @ExceptionTest(ArithmeticException.class)
    public static void test3() {}
}
