package ar.com.problems.numbers;

import ar.com.problems.string.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareDigitTest extends BaseTest {

    @Test
    public void testSquareDigits() {
        assertEquals(811181, SquareDigit.squareDigits(9119));
        assertEquals(0, SquareDigit.squareDigits(0));
    }

    @Test
    public void testSquareDigitsIntStream() {
        assertEquals(811181, SquareDigit.squareDigitsStream(9119));
        assertEquals(0, SquareDigit.squareDigitsStream(0));
    }

}