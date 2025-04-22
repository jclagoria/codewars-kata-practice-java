package ar.com.problems.numbers;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.class)
class LookingForABenefactorTest {

    @Test
    @Order(1)
    public void testEmptyArray() {
        double[] arr = new double[0];
        double navg = 10.0;
        long result = LookingForABenefactor.newAvg(arr, navg);
        assertEquals(10, result);
    }

    @Test
    @Order(2)
    void sampleTests() {
        double[] a = new double[] {14.0, 30.0, 5.0, 7.0, 9.0, 11.0, 16.0};
        assertEquals(628, LookingForABenefactor.newAvg(a, 90), "arr = [14, 30, 5, 7, 9, 11, 16], navg = 90");
        a = new double[] {14, 30, 5, 7, 9, 11, 15};
        assertEquals(645, LookingForABenefactor.newAvg(a, 92), "arr = [14, 30, 5, 7, 9, 11, 15], navg = 92");
    }

    @Test
    @Order(3)
    void testIllegalArgumentException() {
        double[] a = new double[] {14, 30, 5, 7, 9, 11, 15};
        assertThrows(IllegalArgumentException.class, () -> LookingForABenefactor.newAvg(a, 2), "arr = [14, 30, 5, 7, 9, 11, 15], navg = 2");
    }

    @Test
    @Order(4)
    public void testPositiveNumbers() {
        double[] arr = new double[] {14.0, 30.0, 5.0, 7.0, 9.0, 11.0, 16.0};
        double navg = 90.0;
        long result = LookingForABenefactor.newAvg(arr, navg);
        assertEquals(628, result);
    }
    @Test
    @Order(5)
    public void testNavgLteCurrentAverage() {
        double[] arr = new double[] {14, 30, 5, 7, 9, 11, 15};
        double navg = 2.0;
        assertThrows(IllegalArgumentException.class, () -> LookingForABenefactor.newAvg(arr, navg));
    }
    @Test
    @Order(6)
    public void testZeroOrNegativeNumbers() {
        double[] arr = new double[] {-1, 0, 1};
        double navg = 10.0;
        long result = LookingForABenefactor.newAvg(arr, navg);
        assertEquals(40, result);
    }

    @Test
    @Order(7)
    public void testNavgZero() {
        double[] arr = new double[] {1, 2, 3};
        double navg = 0.0;
        assertThrows(IllegalArgumentException.class, () -> LookingForABenefactor.newAvg(arr, navg));
    }
    @Test
    @Order(8)
    public void testNavgNegative() {
        double[] arr = new double[] {1, 2, 3};
        double navg = -1.0;
        assertThrows(IllegalArgumentException.class, () -> LookingForABenefactor.newAvg(arr, navg));
    }

    @Test
    @Order(9)
    void testEmptyArray2() {
        double[] empty = {};
        assertEquals(30, LookingForABenefactor.newAvg(empty, 30));
        assertEquals(1, LookingForABenefactor.newAvg(empty, 0.01));
    }

}