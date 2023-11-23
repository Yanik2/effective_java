package org.example.test;

import org.example.annotation.Test;

public class TestClass {
    //Should success
    @Test
    public static void test1() {

    }

    //Should not be invoked
    public static void test2() {

    }

    //Should fail
    @Test
    public static void test3() {
        throw new RuntimeException();
    }

    public static void test4() {

    }

    // INVALID USE non-static method
    @Test
    public void test5() {}

    public static void test6() {}

    //Should fail
    @Test
    public static void test7() {
        throw new RuntimeException();
    }

    public static void test8() {}
}
