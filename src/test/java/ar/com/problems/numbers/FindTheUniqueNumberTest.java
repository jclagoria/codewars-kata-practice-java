package ar.com.problems.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindTheUniqueNumberTest {

    private double precision = 0.0000000000001;

    @Test
    public void sampleTestCases() {
        assertEquals(1.0, FindTheUniqueNumber.findUniq(new double[]{0, 1, 0}), precision);
        assertEquals(2.0, FindTheUniqueNumber.findUniq(new double[]{1, 1, 1, 2, 1, 1}), precision);
    }

    @Test
    public void testUniqueNumberIsFirstElement() {
        double[] arr = {1, 2, 2, 2};
        assertEquals(1, FindTheUniqueNumber.findUniq(arr), precision);
    }
    @Test
    public void testUniqueNumberIsSecondElement() {
        double[] arr = {2, 1, 2, 2};
        assertEquals(1, FindTheUniqueNumber.findUniq(arr), precision);
    }
    @Test
    public void testUniqueNumberIsThirdElement() {
        double[] arr = {2, 2, 1, 2};
        assertEquals(1, FindTheUniqueNumber.findUniq(arr), precision);
    }
    @Test
    public void testUniqueNumberIsInMiddleOfArray() {
        double[] arr = {2, 2, 2, 1, 2, 2};
        assertEquals(1, FindTheUniqueNumber.findUniq(arr), precision);
    }
    @Test
    public void testUniqueNumberIsAtEndOfArray() {
        double[] arr = {2, 2, 2, 2, 1};
        assertEquals(1, FindTheUniqueNumber.findUniq(arr), precision);
    }
    @Test
    public void testArrayContainsOnlyThreeElements() {
        double[] arr = {1, 2, 2};
        assertEquals(1, FindTheUniqueNumber.findUniq(arr), precision);
    }
    @Test
    public void testArrayContainsMoreThanThreeElements() {
        double[] arr = {2, 2, 2, 2, 2, 1};
        assertEquals(1, FindTheUniqueNumber.findUniq(arr), precision);
    }
    @Test
    public void testArrayContainsDuplicateValues() {
        double[] arr = {2, 2, 2, 2, 2, 1, 1, 1};
        assertEquals(1, FindTheUniqueNumber.findUniq(arr), precision);
    }

}