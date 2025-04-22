package ar.com.problems.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OnesAndZerosTest {

    @Test
    public void testConvertBinaryArrayToInt_ValidInput() {
        List<Integer> binary = Arrays.asList(1, 0, 1, 0);
        int result = OnesAndZeros.convertBinaryArrayToInt(binary);
        assertEquals(10, result);
    }

    @Test
    public void testConvertBinaryArrayToInt_EmptyInput() {
        List<Integer> binary = Arrays.asList();
        int result = OnesAndZeros.convertBinaryArrayToInt(binary);
        assertEquals(0, result);
    }

    @Test
    public void testConvertBinaryArrayToInt_InvalidInput() {
        List<Integer> binary = Arrays.asList(1, 2, 0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            OnesAndZeros.convertBinaryArrayToInt(binary);
        });
        assertEquals("Array must contain only 0s and 1s", exception.getMessage());
    }

    @Test
    public void convertBinaryArrayToInt() throws Exception {

        assertEquals(1, OnesAndZeros.convertBinaryArrayToInt(new ArrayList<>(Arrays.asList(0,0,0,1))));
        assertEquals(15, OnesAndZeros.convertBinaryArrayToInt(new ArrayList<>(Arrays.asList(1,1,1,1))));
        assertEquals(6, OnesAndZeros.convertBinaryArrayToInt(new ArrayList<>(Arrays.asList(0,1,1,0))));
        assertEquals(9, OnesAndZeros.convertBinaryArrayToInt(new ArrayList<>(Arrays.asList(1,0,0,1))));


    }

    @Test
    public void testConvertBinaryArrayToIntFunctional_ValidInput() {
        List<Integer> binary = Arrays.asList(1, 0, 1, 0);
        int result = OnesAndZeros.binaryArrayToNumberFunctional(binary);
        assertEquals(10, result);
    }

    @Test
    public void testConvertBinaryArrayToIntFunctional_EmptyInput() {
        List<Integer> binary = Arrays.asList();
        int result = OnesAndZeros.binaryArrayToNumberFunctional(binary);
        assertEquals(0, result);
    }

    @Test
    public void testConvertBinaryArrayToIntFunctional_InvalidInput() {
        List<Integer> binary = Arrays.asList(1, 2, 0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            OnesAndZeros.binaryArrayToNumberFunctional(binary);
        });
        assertEquals("Array must contain only 0s and 1s", exception.getMessage());
    }

    @Test
    public void convertBinaryArrayToIntFunctional() throws Exception {
        assertEquals(1, OnesAndZeros.binaryArrayToNumberFunctional(new ArrayList<>(Arrays.asList(0,0,0,1))));
        assertEquals(15, OnesAndZeros.binaryArrayToNumberFunctional(new ArrayList<>(Arrays.asList(1,1,1,1))));
        assertEquals(6, OnesAndZeros.binaryArrayToNumberFunctional(new ArrayList<>(Arrays.asList(0,1,1,0))));
        assertEquals(9, OnesAndZeros.binaryArrayToNumberFunctional(new ArrayList<>(Arrays.asList(1,0,0,1))));
    }

    @Test
    public void testConvertBinaryArrayToIntFunctionalByIndex_ValidInput() {
        List<Integer> binary = Arrays.asList(1, 0, 1, 0);
        int result = OnesAndZeros.binaryArrayToIntByIndex(binary);
        assertEquals(10, result);
    }

    @Test
    public void testConvertBinaryArrayToIntFunctionalByIndex_EmptyInput() {
        List<Integer> binary = Arrays.asList();
        int result = OnesAndZeros.binaryArrayToIntByIndex(binary);
        assertEquals(0, result);
    }

    @Test
    public void testConvertBinaryArrayToIntFunctionalByIndex_InvalidInput() {
        List<Integer> binary = Arrays.asList(1, 2, 0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            OnesAndZeros.binaryArrayToIntByIndex(binary);
        });
        assertEquals("Array must contain only 0s and 1s", exception.getMessage());
    }

    @Test
    public void convertBinaryArrayToIntFunctionalByIndex() throws Exception {

        assertEquals(1, OnesAndZeros.binaryArrayToIntByIndex(new ArrayList<>(Arrays.asList(0,0,0,1))));
        assertEquals(15, OnesAndZeros.binaryArrayToIntByIndex(new ArrayList<>(Arrays.asList(1,1,1,1))));
        assertEquals(6, OnesAndZeros.binaryArrayToIntByIndex(new ArrayList<>(Arrays.asList(0,1,1,0))));
        assertEquals(9, OnesAndZeros.binaryArrayToIntByIndex(new ArrayList<>(Arrays.asList(1,0,0,1))));


    }

}