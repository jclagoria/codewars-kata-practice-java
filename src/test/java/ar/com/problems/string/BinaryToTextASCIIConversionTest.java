package ar.com.problems.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryToTextASCIIConversionTest {

    @Test
    public void testHello() {
        assertEquals(
                "Hello",
                BinaryToTextASCIIConversion.binaryToText("0100100001100101011011000110110001101111"));
    }

    @Test
    public void testEmptyString() {
        assertEquals(
                "",
                BinaryToTextASCIIConversion.binaryToText(""));
    }

    @Test
    public void testNullInput() {
        assertEquals(
                "",
                BinaryToTextASCIIConversion.binaryToText(null));
    }

    @Test
    public void testSingleCharacter() {
        assertEquals(
                "A",
                BinaryToTextASCIIConversion.binaryToText("01000001"));
    }

    @Test
    public void testMixedCase() {
        assertThrows(IllegalArgumentException.class, () -> {
            BinaryToTextASCIIConversion.binaryToText("0100100001100101011011000110110001101111001011000010000001010111011011110111001001101100011001000010000100"); // Not a multiple of 8
        });
    }

    @Test
    public void testInvalidBinaryLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            BinaryToTextASCIIConversion.binaryToText("0101"); // Not a multiple of 8
        });
    }

    @Test
    public void testHelloFP() {
        assertEquals(
                "Hello",
                BinaryToTextASCIIConversion.binaryToTextFP("0100100001100101011011000110110001101111"));
    }

    @Test
    public void testEmptyStringFP() {
        assertEquals(
                "",
                BinaryToTextASCIIConversion.binaryToTextFP(""));
    }

    @Test
    public void testMixedCaseFP() {
        assertThrows(IllegalArgumentException.class, () -> {
            BinaryToTextASCIIConversion.binaryToTextFP("0100100001100101011011000110110001101111001011000010000001010111011011110111001001101100011001000010000100"); // Not a multiple of 8
        });
    }

    @Test
    public void testInvalidBinaryLengthFP() {
        assertThrows(IllegalArgumentException.class, () -> {
            BinaryToTextASCIIConversion.binaryToTextFP("0101"); // Not a multiple of 8
        });
    }
}