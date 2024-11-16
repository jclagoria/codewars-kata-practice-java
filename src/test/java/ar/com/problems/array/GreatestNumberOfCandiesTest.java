package ar.com.problems.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GreatestNumberOfCandiesTest {

    @Test
    @DisplayName("Should return a List of Booleans -> [true, true, true, false, true]")
    public void testKidsWithCandiesExample1() {
        int[] candies = {2,3,5,1,3};
        List<Boolean> resultExpected = Arrays.asList(true, true, true, false, true);
        assertEquals(resultExpected, GreatestNumberOfCandies.kidsWithCandies(candies, 3));
    }

    @Test
    @DisplayName("Should return a List of Booleans -> [true,false,false,false,false]")
    public void testKidsWithCandiesExample2() {
        int[] candies = {4,2,1,1,2};
        List<Boolean> resultExpected = Arrays.asList(true,false,false,false,false);
        assertEquals(resultExpected, GreatestNumberOfCandies.kidsWithCandies(candies, 1));
    }

    @Test
    @DisplayName("Should return a List of Booleans -> [true,false,true]")
    public void testKidsWithCandiesExample3() {
        int[] candies = {12,1,12};
        List<Boolean> resultExpected = Arrays.asList(true,false,true);
        assertEquals(resultExpected, GreatestNumberOfCandies.kidsWithCandies(candies, 1));
    }

    @Test
    @DisplayName("Should return a List of Booleans -> [true, true, true, false, true]")
    public void testKidsWithCandiesSolutionWithStreamExample1() {
        int[] candies = {2,3,5,1,3};
        List<Boolean> resultExpected = Arrays.asList(true, true, true, false, true);
        assertEquals(resultExpected, GreatestNumberOfCandies
                .kidsWithCandiesSolutionWithStream(candies, 3));
    }

    @Test
    @DisplayName("Should return a List of Booleans -> [true,false,false,false,false]")
    public void testKidsWithCandiesSolutionWithStreamExample2() {
        int[] candies = {4,2,1,1,2};
        List<Boolean> resultExpected = Arrays.asList(true,false,false,false,false);
        assertEquals(resultExpected, GreatestNumberOfCandies
                .kidsWithCandiesSolutionWithStream(candies, 1));
    }

    @Test
    @DisplayName("Should return a List of Booleans -> [true,false,true]")
    public void testKidsWithCandiesSolutionWithStreamExample3() {
        int[] candies = {12,1,12};
        List<Boolean> resultExpected = Arrays.asList(true,false,true);
        assertEquals(resultExpected, GreatestNumberOfCandies
                .kidsWithCandiesSolutionWithStream(candies, 1));
    }

    @Test
    @DisplayName("Should return a List of Booleans -> [true, true, true, false, true]")
    public void testKdsWithCandiesBestSolutionExample1() {
        int[] candies = {2,3,5,1,3};
        List<Boolean> resultExpected = Arrays.asList(true, true, true, false, true);
        assertEquals(resultExpected, GreatestNumberOfCandies
                .kidsWithCandiesBestSolution(candies, 3));
    }

    @Test
    @DisplayName("Should return a List of Booleans -> [true,false,false,false,false]")
    public void testKdsWithCandiesBestSolutionExample2() {
        int[] candies = {4,2,1,1,2};
        List<Boolean> resultExpected = Arrays.asList(true,false,false,false,false);
        assertEquals(resultExpected, GreatestNumberOfCandies
                .kidsWithCandiesBestSolution(candies, 1));
    }

    @Test
    @DisplayName("Should return a List of Booleans -> [true,false,true]")
    public void testKdsWithCandiesBestSolutionExample3() {
        int[] candies = {12,1,12};
        List<Boolean> resultExpected = Arrays.asList(true,false,true);
        assertEquals(resultExpected, GreatestNumberOfCandies
                .kidsWithCandiesBestSolution(candies, 1));
    }
}