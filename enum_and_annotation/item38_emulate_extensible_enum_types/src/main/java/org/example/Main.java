package org.example;

import org.example.calculator.BasicOperation;
import org.example.calculator.Operation;

import java.util.Arrays;
import java.util.Collection;

import static org.example.calculator.BasicOperation.*;
import static org.example.calculator.ExtendedOperation.EXP;
import static org.example.calculator.ExtendedOperation.REMAINDER;

public class Main {
    public static void main(String[] args) {
        final var plus = calculate(PLUS, 1, 2);
        final var minus = calculate(MINUS, 1, 2);
        final var times = calculate(TIMES, 1, 2);
        final var divide = calculate(DIVIDE, 1, 2);
        final var exp = calculate(EXP, 2, 2);
        final var remainder = calculate(REMAINDER, 10, 3);

        test(BasicOperation.class, 3, 4);
        testWildcard(Arrays.asList(BasicOperation.values()), 3, 4);
    }

    private static double calculate(Operation operation, double x, double y) {
        return operation.apply(x, y);
    }

    private static <T extends Enum<T> & Operation> void test(Class<T> enumType, double x, double y) {
        for (Operation op : enumType.getEnumConstants()) {
            System.out.println("Operation name: " + op + " result: " + op.apply(x, y));
        }
    }

    private static void testWildcard(Collection<? extends Operation> ops, double x, double y) {
        for (Operation op : ops) {
            System.out.println("Operation name: " + op + " result: " + op.apply(x, y));
        }
    }
}