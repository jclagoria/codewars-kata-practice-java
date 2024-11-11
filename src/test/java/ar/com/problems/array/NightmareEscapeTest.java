package ar.com.problems.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NightmareEscapeTest {

    @Test
    @DisplayName("Should return a success, find the safest path - 7")
    public void findSafestPath_testSuccess() {
        int[][] dream = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        assertEquals(7, NightmareEscape.findSafestPath(dream));
    }

}