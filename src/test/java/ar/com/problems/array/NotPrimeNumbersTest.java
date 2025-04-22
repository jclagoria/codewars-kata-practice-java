package ar.com.problems.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NotPrimeNumbersTest {

    @Test
    public void basicTests() {
        assertEquals(Arrays.asList(22, 25, 27, 32, 33, 35, 52, 55, 57, 72, 75, 77), NotPrimeNumbers.notPrimes(   2,  222));
        assertEquals(Arrays.asList(2722, 2723, 2725, 2727, 2732, 2733, 2735, 2737, 2752, 2755, 2757, 2772, 2773, 2775), NotPrimeNumbers.notPrimes(2700, 3000));
        assertEquals(Arrays.asList(522, 525, 527, 532, 533, 535, 537, 552, 553, 555, 572, 573, 575, 722, 723, 725, 732, 735, 737, 752, 753, 755, 772, 775, 777), NotPrimeNumbers.notPrimes( 500,  999));
        assertEquals(Arrays.asList(2222, 2223, 2225, 2227, 2232, 2233, 2235, 2252, 2253, 2255, 2257, 2272, 2275, 2277, 2322, 2323, 2325, 2327, 2332, 2335, 2337, 2352, 2353, 2355, 2372, 2373, 2375), NotPrimeNumbers.notPrimes( 999, 2500));
    }

    @Test
    public void testEmptyRange() {
        List<Integer> result = NotPrimeNumbers.notPrimes(10, 10);
        assertTrue(result.isEmpty());
    }
    @Test
    public void testSingleElementRange() {
        List<Integer> result = NotPrimeNumbers.notPrimes(10, 11);
        assertTrue(result.isEmpty());
    }
    @Test
    public void testNoNotPrimes() {
        List<Integer> result = NotPrimeNumbers.notPrimes(2, 5);
        assertTrue(result.isEmpty());
    }
    @Test
    public void testNotPrimes() {
        List<Integer> result = NotPrimeNumbers.notPrimes(20, 30);
        assertEquals(Arrays.asList(22, 25, 27), result);
    }
    @Test
    public void testNotAllDigitsPrime() {
        List<Integer> result = NotPrimeNumbers.notPrimes(10, 20);
        assertTrue(result.isEmpty());
    }
    @Test
    public void testEdgeCaseA0() {
        List<Integer> result = NotPrimeNumbers.notPrimes(0, 10);
        assertEquals(Arrays.asList(0), result);
    }
    @Test
    public void testEdgeCaseBMax() {
        List<Integer> result = NotPrimeNumbers.notPrimes(19900, 20000);
        assertTrue(result.isEmpty());
    }

}