package ar.com.problems.array;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RemoveDuplicatesFromListTest {

    @Test @Order(0) @DisplayName("Empty array")
    void emptyArray() {
        test(new int[0], new int[0]);
        testLinkedHashSet(new int[0], new int[0]);
        testWithHashSet(new int[0], new int[0]);
        testWithHashStream(new int[0], new int[0]);
    }

    @Test @Order(1) @DisplayName("Array of one element")
    void oneElement() {
        test(new int[]{1}, new int[]{1});
        testLinkedHashSet(new int[]{1}, new int[]{1});
        testWithHashSet(new int[]{1}, new int[]{1});
        testWithHashStream(new int[]{1}, new int[]{1});
    }

    @Test @Order(2) @DisplayName("Array of distinct elements")
    void distinctElements() {
        test(new int[]{1,2}, new int[]{1,2});
        testLinkedHashSet(new int[]{1,2}, new int[]{1,2});
        testWithHashSet(new int[]{1,2}, new int[]{1,2});
        testWithHashStream(new int[]{1,2}, new int[]{1,2});
    }

    @Test @Order(3) @DisplayName("Basic test case 1")
    void testBasicOne() {
        test(new int[]{1,2}, new int[]{1,1,2});
        testLinkedHashSet(new int[]{1,2}, new int[]{1,1,2});
        testWithHashStream(new int[]{1,2}, new int[]{1,1,2});
    }

    @Test @Order(4) @DisplayName("Basic test case 2")
    void testBasicTwo() {
        test(new int[]{1,2,3,4,5}, new int[]{1, 1, 1, 2, 3, 4, 5});
        testLinkedHashSet(new int[]{1,2,3,4,5}, new int[]{1, 1, 1, 2, 3, 4, 5});
        testWithHashStream(new int[]{1,2,3,4,5}, new int[]{1, 1, 1, 2, 3, 4, 5});
    }

    @Test @Order(5) @DisplayName("Basic test case 3")
    void testBasicThree() {
        test(new int[]{1,2,3,4,5,6,7}, new int[]{1, 2, 2, 1, 3, 3, 1, 4, 2, 4, 5, 6, 7, 7, 7});
        testLinkedHashSet(new int[]{1,2,3,4,5,6,7}, new int[]{1, 2, 2, 1, 3, 3, 1, 4, 2, 4, 5, 6, 7, 7, 7});
        testWithHashStream(new int[]{1,2,3,4,5,6,7}, new int[]{1, 2, 2, 1, 3, 3, 1, 4, 2, 4, 5, 6, 7, 7, 7});
    }

    private void test(int[] expected, int[] input) {
        int[] actual = RemoveDuplicatesFromList.distinct(input.clone());
        String msg = "For input: " + (input.length < 100 ?
                Arrays.toString(input) : "[(" + input.length + " elements)]")
                + "\nexpected:  " + Arrays.toString(expected)
                + "\nactual:    " + Arrays.toString(actual) + "\n";
        assertArrayEquals(expected, actual, msg);
    }

    private void testLinkedHashSet(int[] expected, int[] input) {
        int[] actual = RemoveDuplicatesFromList.distinctLinkedHashSet(input.clone());
        String msg = "For input: " + (input.length < 100 ?
                Arrays.toString(input) : "[(" + input.length + " elements)]")
                + "\nexpected:  " + Arrays.toString(expected)
                + "\nactual:    " + Arrays.toString(actual) + "\n";
        assertArrayEquals(expected, actual, msg);
    }

    private void testWithHashSet(int[] expected, int[] input) {
        int[] actual = RemoveDuplicatesFromList.distinctWithHashSet(input.clone());
        String msg = "For input: " + (input.length < 100 ?
                Arrays.toString(input) : "[(" + input.length + " elements)]")
                + "\nexpected:  " + Arrays.toString(expected)
                + "\nactual:    " + Arrays.toString(actual) + "\n";
        assertArrayEquals(expected, actual, msg);
    }

    private void testWithHashStream(int[] expected, int[] input) {
        int[] actual = RemoveDuplicatesFromList.distinctStream(input.clone());
        String msg = "For input: " + (input.length < 100 ?
                Arrays.toString(input) : "[(" + input.length + " elements)]")
                + "\nexpected:  " + Arrays.toString(expected)
                + "\nactual:    " + Arrays.toString(actual) + "\n";
        assertArrayEquals(expected, actual, msg);
    }

}