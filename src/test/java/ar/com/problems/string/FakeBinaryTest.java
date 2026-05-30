package ar.com.problems.string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class FakeBinaryTest {

    @Test
    public void testSomething() {
        assertEquals("01011110001100111", FakeBinary.fakeBin("45385593107843568"));
        assertEquals("101000111101101", FakeBinary.fakeBin("509321967506747"));
        assertEquals("011011110000101010000011011", FakeBinary.fakeBin("366058562030849490134388085"));
    }

    @Test
    void allDigitsBelowFiveBecomeZeros() {
        String input = "01234";
        String expected = "00000";
        assertThat(FakeBinary.fakeBin(input)).isEqualTo(expected);
    }

    @Test
    void allDigitsFiveAndAboveBecomeOnes() {
        String input = "56789";
        String expected = "11111";
        assertThat(FakeBinary.fakeBin(input)).isEqualTo(expected);
    }

    @Test
    void mixedDigitsConvertedCorrectly() {
        String input = "45385593107843568";
        String expected = "01011110001100111";
        assertThat(FakeBinary.fakeBin(input)).isEqualTo(expected);
    }

    @Test
    void singleDigitZero() {
        assertThat(FakeBinary.fakeBin("0")).isEqualTo("0");
    }

    @Test
    void singleDigitFive() {
        assertThat(FakeBinary.fakeBin("5")).isEqualTo("1");
    }

    @Test
    void randomExample() {
        String input = "1234567890";
        String expected = "0000111110";
        assertThat(FakeBinary.fakeBin(input)).isEqualTo(expected);
    }

    @Test
    void longStringPerformance() {
        // Generate a long input string of random digits
        StringBuilder sb = new StringBuilder();
        StringBuilder expected = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            char digit = (char) ('0' + (i % 10));
            sb.append(digit);
            expected.append(digit < '5' ? '0' : '1');
        }
        String input = sb.toString();
        String expectedResult = expected.toString();

        assertThat(FakeBinary.fakeBin(input))
                .isEqualTo(expectedResult);
    }

    @Test
    public void testSomethingFP() {
        assertEquals("01011110001100111", FakeBinary.fakeBingFunctional("45385593107843568"));
        assertEquals("101000111101101", FakeBinary.fakeBingFunctional("509321967506747"));
        assertEquals("011011110000101010000011011", FakeBinary.fakeBingFunctional("366058562030849490134388085"));
    }

    @Test
    void allDigitsBelowFiveBecomeZerosFP() {
        String input = "01234";
        String expected = "00000";
        assertThat(FakeBinary.fakeBingFunctional(input)).isEqualTo(expected);
    }

    @Test
    void allDigitsFiveAndAboveBecomeOnesFP() {
        String input = "56789";
        String expected = "11111";
        assertThat(FakeBinary.fakeBingFunctional(input)).isEqualTo(expected);
    }

    @Test
    void mixedDigitsConvertedCorrectlyFP() {
        String input = "45385593107843568";
        String expected = "01011110001100111";
        assertThat(FakeBinary.fakeBingFunctional(input)).isEqualTo(expected);
    }

    @Test
    void singleDigitZeroFP() {
        assertThat(FakeBinary.fakeBingFunctional("0")).isEqualTo("0");
    }

    @Test
    void singleDigitFiveFP() {
        assertThat(FakeBinary.fakeBingFunctional("5")).isEqualTo("1");
    }

    @Test
    void randomExampleFP() {
        String input = "1234567890";
        String expected = "0000111110";
        assertThat(FakeBinary.fakeBingFunctional(input)).isEqualTo(expected);
    }

    @Test
    void longStringPerformanceFP() {
        // Generate a long input string of random digits
        StringBuilder sb = new StringBuilder();
        StringBuilder expected = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            char digit = (char) ('0' + (i % 10));
            sb.append(digit);
            expected.append(digit < '5' ? '0' : '1');
        }
        String input = sb.toString();
        String expectedResult = expected.toString();

        assertThat(FakeBinary.fakeBingFunctional(input))
                .isEqualTo(expectedResult);
    }

}