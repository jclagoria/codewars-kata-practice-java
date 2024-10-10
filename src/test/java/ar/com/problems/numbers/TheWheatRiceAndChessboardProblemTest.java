package ar.com.problems.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TheWheatRiceAndChessboardProblemTest {
    @Test
    void basicTests() {
        assertEquals(0, TheWheatRiceAndChessboardProblem.squaresNeeded(0));
        assertEquals(1, TheWheatRiceAndChessboardProblem.squaresNeeded(1));
        assertEquals(2, TheWheatRiceAndChessboardProblem.squaresNeeded(2));
        assertEquals(2, TheWheatRiceAndChessboardProblem.squaresNeeded(3));
        assertEquals(3, TheWheatRiceAndChessboardProblem.squaresNeeded(4));
        assertEquals(4, TheWheatRiceAndChessboardProblem.squaresNeeded(8), "8 grains should need 4 squares.");
        assertEquals(57, TheWheatRiceAndChessboardProblem.squaresNeeded(72057594037927936L),
                "Maximum grains for 64 squares should need 64 squares.");
    }

    @Test
    public void testEightGrainsBinaryToString() {
        assertEquals(0, TheWheatRiceAndChessboardProblem.squaresNeededBinaryToString(0));
        assertEquals(1, TheWheatRiceAndChessboardProblem.squaresNeededBinaryToString(1));
        assertEquals(2, TheWheatRiceAndChessboardProblem.squaresNeededBinaryToString(2));
        assertEquals(2, TheWheatRiceAndChessboardProblem.squaresNeededBinaryToString(3));
        assertEquals(3, TheWheatRiceAndChessboardProblem.squaresNeededBinaryToString(4));
        assertEquals(4, TheWheatRiceAndChessboardProblem.squaresNeededBinaryToString(8), "8 grains should need 4 squares.");
        assertEquals(57, TheWheatRiceAndChessboardProblem.squaresNeededBinaryToString(72057594037927936L),
                "Maximum grains for 64 squares should need 64 squares.");
    }

}