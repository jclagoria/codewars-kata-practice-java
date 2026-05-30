package ar.com.problems.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testng.annotations.Ignore;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PrintingArrayElementsWithCommaDelimitersTest {

    @Test
    @DisplayName("Example test")
    void testInteger() {
        Integer[] array = new Integer[] { 2, 4, 5, 2 };
        assertEquals("2,4,5,2", PrintingArrayElementsWithCommaDelimiters
                .printArray(array), "Testing with: [2,4,5,2]");
    }

    @Test
    void shouldJoinSimpleArray() {
        Object[] input = {"h", "o", "l", "a"};
        String result = PrintingArrayElementsWithCommaDelimiters.printArray(input);
        assertThat(result).isEqualTo("h,o,l,a");
    }

    @Test
    void shouldReturnEmptyForNullOrEmpty() {
        assertThat(PrintingArrayElementsWithCommaDelimiters.printArray(null)).isEmpty();
        assertThat(PrintingArrayElementsWithCommaDelimiters.printArray(new Object[0])).isEmpty();
    }

    @Test
    void shouldHandleNullElements() {
        Object[] input = {null, "X", null};
        String result = PrintingArrayElementsWithCommaDelimiters.printArray(input);
        // null → "null"
        assertThat(result).isEqualTo("null,X,null");
    }

    @Test
    @Ignore
    void shouldHandleNestedPrimitiveAndObjectArrays() {
        Object[] input = {
                new int[]{1,2,3},
                new String[]{"a","b"},
                new boolean[]{true,false}
        };
        String result = PrintingArrayElementsWithCommaDelimiters.printArray(input);
        // Arrays.toString(int[]) → "[1, 2, 3]"
        // Arrays.toString(boolean[]) → "[true, false]"
        // Arrays.deepToString(Object[]) → "[a, b]"
        assertThat(result).isEqualTo("[1,2,3],[a,b],[true,false]");
    }

}