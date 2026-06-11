package ar.com.problems.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BlockPlacementQueriesTest {

    @Test
    @DisplayName("Should place obstacles and check block placement with first input")
    public void blockPlacement_firstTest() {
        var solver = new BlockPlacementQueries();
        var queries = new int[][]{{1, 2}, {2, 3, 3}, {2, 3, 1}, {2, 2, 2}};
        var expected = List.of(false, true, true);
        assertEquals(expected, solver.getResults(queries));
    }

    @Test
    @DisplayName("Should place obstacles and check block placement with second input")
    public void blockPlacement_secondTest() {
        var solver = new BlockPlacementQueries();
        var queries = new int[][]{{1, 7}, {2, 7, 6}, {1, 2}, {2, 7, 5}, {2, 7, 6}};
        var expected = List.of(true, true, false);
        assertEquals(expected, solver.getResults(queries));
    }
}
