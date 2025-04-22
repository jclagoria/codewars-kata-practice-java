package ar.com.problems.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfTwoIntegersTest {

    @Test
    void testPositiveNumbers() {
        assertEquals(24, SumOfTwoIntegers.add(5, 19));
        assertEquals(100, SumOfTwoIntegers.add(60, 40));
    }

    @Test
    void testNegativeNumbers() {
        assertEquals(-30, SumOfTwoIntegers.add(-14, -16));
        assertEquals(-9, SumOfTwoIntegers.add(-27, 18));
        assertEquals(-45, SumOfTwoIntegers.add(-50, 5));
    }

    @Test
    void testWithZero() {
        assertEquals(0, SumOfTwoIntegers.add(0, 0));
        assertEquals(10, SumOfTwoIntegers.add(0, 10));
        assertEquals(-10, SumOfTwoIntegers.add(-10, 0));
    }

    @Test
    void testOppositeNumbers() {
        assertEquals(0, SumOfTwoIntegers.add(-5, 5));
        assertEquals(0, SumOfTwoIntegers.add(123456, -123456));
    }

    @Test
    void testLargeNumbers() {
        assertEquals(2_000_000_000, SumOfTwoIntegers.add(1_000_000_000, 1_000_000_000));
        assertEquals(-2_000_000_000, SumOfTwoIntegers.add(-1_000_000_000, -1_000_000_000));
    }





    @Test
    void testPositiveNumbersRecursive() {
        assertEquals(24, SumOfTwoIntegers.addRecursive(5, 19));
        assertEquals(100, SumOfTwoIntegers.addRecursive(60, 40));
    }

    @Test
    void testNegativeNumbersRecursive() {
        assertEquals(-30, SumOfTwoIntegers.addRecursive(-14, -16));
        assertEquals(-9, SumOfTwoIntegers.addRecursive(-27, 18));
        assertEquals(-45, SumOfTwoIntegers.addRecursive(-50, 5));
    }

    @Test
    void testWithZeroRecursive() {
        assertEquals(0, SumOfTwoIntegers.addRecursive(0, 0));
        assertEquals(10, SumOfTwoIntegers.addRecursive(0, 10));
        assertEquals(-10, SumOfTwoIntegers.addRecursive(-10, 0));
    }

    @Test
    void testOppositeNumbersRecursive() {
        assertEquals(0, SumOfTwoIntegers.add(-5, 5));
        assertEquals(0, SumOfTwoIntegers.add(123456, -123456));
    }

    @Test
    void testLargeNumbersRecursive() {
        assertEquals(2_000_000_000, SumOfTwoIntegers.add(1_000_000_000, 1_000_000_000));
        assertEquals(-2_000_000_000, SumOfTwoIntegers.add(-1_000_000_000, -1_000_000_000));
    }



}