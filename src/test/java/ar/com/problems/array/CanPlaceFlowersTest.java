package ar.com.problems.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CanPlaceFlowersTest {

    @Test
    @DisplayName("canPlaceFlowers - Should return a success value True with this entry data flowerbed = {1, 0, 0, 0, 1} and n = 1")
    public void testCanPlaceFlowers_SuccessExample1() {
        int[] flowerbed = {1, 0, 0, 0, 1};
        assertTrue(CanPlaceFlowers.canPlaceFlowers(flowerbed, 1));
    }

    @Test
    @DisplayName("canPlaceFlowers - Should return a success value True with this entry data flowerbed = {1, 0, 0, 0, 1} and n = 2")
    public void testCanPlaceFlowers_SuccessExample2() {
        int[] flowerbed = {1, 0, 0, 0, 1};
        assertFalse(CanPlaceFlowers.canPlaceFlowers(flowerbed, 2));
    }

    @Test
    @DisplayName("canPlaceFlowers - Should return a success value True with this entry data flowerbed = {0, 0, 1, 0, 0} and n = 1")
    public void testCanPlaceFlowers_SuccessExample3() {
        int[] flowerbed = {0, 0, 1, 0, 0};
        assertTrue(CanPlaceFlowers.canPlaceFlowers(flowerbed, 1));
    }

    @Test
    @DisplayName("canPlaceFlowers - Should return a success value True with this entry data flowerbed = {1, 0, 0, 0, 0} and n = 2")
    public void testCanPlaceFlowers_SuccessExample4() {
        int[] flowerbed = {1, 0, 0, 0, 0};
        assertTrue(CanPlaceFlowers.canPlaceFlowers(flowerbed, 2));
    }

    @Test
    @DisplayName("canPlaceFlowers - Should return a success value True with this entry data flowerbed = { 0, 1, 0} and n = 1")
    public void testCanPlaceFlowers_SuccessExample5() {
        int[] flowerbed = {0, 1, 0};
        assertFalse(CanPlaceFlowers.canPlaceFlowers(flowerbed, 1));
    }

        @Test
    @DisplayName("canPlaceFlowersBestSolution - Should return a success value True with this entry data flowerbed = {1, 0, 0, 0, 1} and n = 1")
    public void testCanPlaceFlowersBestSolution_SuccessExample1() {
        int[] flowerbed = {1, 0, 0, 0, 1};
        assertTrue(CanPlaceFlowers.canPlaceFlowersBestSolution(flowerbed, 1));
    }

    @Test
    @DisplayName("canPlaceFlowersBestSolution - Should return a success value True with this entry data flowerbed = {1, 0, 0, 0, 1} and n = 2")
    public void testCanPlaceFlowersBestSolution_SuccessExample2() {
        int[] flowerbed = {1, 0, 0, 0, 1};
        assertFalse(CanPlaceFlowers.canPlaceFlowersBestSolution(flowerbed, 2));
    }

    @Test
    @DisplayName("canPlaceFlowersBestSolution - Should return a success value True with this entry data flowerbed = {0, 0, 1, 0, 0} and n = 1")
    public void testCanPlaceFlowersBestSolution_SuccessExample3() {
        int[] flowerbed = {0, 0, 1, 0, 0};
        assertTrue(CanPlaceFlowers.canPlaceFlowersBestSolution(flowerbed, 1));
    }

    @Test
    @DisplayName("canPlaceFlowersBestSolution - Should return a success value True with this entry data flowerbed = {1, 0, 0, 0, 0} and n = 2")
    public void testCanPlaceFlowersBestSolution_SuccessExample4() {
        int[] flowerbed = {1, 0, 0, 0, 0};
        assertTrue(CanPlaceFlowers.canPlaceFlowersBestSolution(flowerbed, 2));
    }

}