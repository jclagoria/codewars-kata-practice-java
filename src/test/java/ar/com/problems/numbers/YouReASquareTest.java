package ar.com.problems.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YouReASquareTest {

    @Test
    public void shouldWorkForSomeExamples() throws Exception {
        assertFalse(YouReASquare.isSquare(-1), "negative numbers aren't square numbers");
        assertTrue(YouReASquare.isSquare(0), "0 is a square number (0 * 0)");
        assertFalse( YouReASquare.isSquare(3), "3 isn't a square number" );
        assertTrue(YouReASquare.isSquare(4), "4 is a square number (2 * 2)");
        assertTrue(YouReASquare.isSquare(25), "25 is a square number (5 * 5)");
        assertFalse(YouReASquare.isSquare(26), "26 isn't a square number");


    }


}