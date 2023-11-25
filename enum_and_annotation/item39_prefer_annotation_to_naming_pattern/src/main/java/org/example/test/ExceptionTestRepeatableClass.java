package org.example.test;

import org.example.annotation.ExceptionTestRepeatable;

public class ExceptionTestRepeatableClass {

    @ExceptionTestRepeatable(NullPointerException.class)
    @ExceptionTestRepeatable(IndexOutOfBoundsException.class)
    public static void test1() {
        throw new NullPointerException();
    }

    @ExceptionTestRepeatable.MyContainer({
            @ExceptionTestRepeatable(NullPointerException.class),
            @ExceptionTestRepeatable(IndexOutOfBoundsException.class)
    })
    public static void test2() {
        throw new NullPointerException();
    }
}
