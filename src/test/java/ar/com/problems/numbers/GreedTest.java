package ar.com.problems.numbers;

import ar.com.problems.string.BaseTest;
import ar.com.problems.string.RemoveRepeatedWords;
import org.junit.Test;

import static org.junit.Assert.*;

public class GreedTest extends BaseTest {

    @Test
    public void firstTest() {
        testing("Score for [5,1,3,4,1] must be 250:", 250, Greed.greedy(new int[]{5,1,3,4,1}));
    }

    @Test
    public void secondValuesTest() {
        testing("Score for [1,1,1,3,1] must be 1100:", 1100, Greed.greedy(new int[]{1,1,1,3,1}));
    }

    @Test
    public void thirdValuesTesting() {
        testing("Score for [2,4,4,5,4] must be 450:", 450, Greed.greedy(new int[]{2,4,4,5,4}));
    }

    @Test
    public void bestSolution() {
        testing("Score for [2,4,4,5,4] must be 450:", 450, Greed.greedyAnotherChance(new int[]{2,4,4,5,4}));
    }

}