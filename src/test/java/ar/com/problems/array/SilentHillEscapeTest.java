package ar.com.problems.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SilentHillEscapeTest {

    @Test
    @DisplayName("Should return a route to scape equal to 8")
    public void testEscapeTest1() {
        char[][] room = {
                {'.', '.', '#', '.', '▲'},
                {'#', '.', '#', '.', '#'},
                {'.', '.', '.', '.', '.'},
                {'#', '#', '#', '.', '#'},
                {'T', '.', '.', '.', '.'},
        };
        assertEquals(8, SilentHillEscape.escapeFromPyramidHead(room));
    }

    @Test
    @DisplayName("Should return a route to scape equal to 2")
    public void testEscapeTest2() {
        char[][] room = {
                { 'T', '.', '#', '.'},
                { '.', '.', '.', '.'},
                { '▲', '.', '.', '#'},
                {'.', '#', '#', '#'},
        };
        assertEquals(2, SilentHillEscape.escapeFromPyramidHead(room));
    }

    @Test
    @DisplayName("Should return a route to scape equal to -1")
    public void testEscapeTest3() {
        char[][] room = {
                {'#', '#', '#'},
                { '▲', '.', '#'},
                {'.', '#', 'T'},
        };
        assertEquals(-1, SilentHillEscape.escapeFromPyramidHead(room));
    }

}