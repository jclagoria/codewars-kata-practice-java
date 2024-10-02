package ar.com.problems.numbers;

import ar.com.problems.string.BaseTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReflectionsTest extends BaseTest {

    @Test
    public void testReflectPoint() {

        assertArrayEquals(new int[]{2, 2}, Reflections.reflectPoint(new int[]{0, 0}, new int[]{1, 1}));
        assertArrayEquals(new int[]{-6, -18}, Reflections.reflectPoint(new int[]{2, 6}, new int[]{-2, -6}));

        assertArrayEquals(new int[]{-30, 30}, Reflections.reflectPoint(new int[]{10, -10}, new int[]{-10, 10}));
        assertArrayEquals(new int[]{-25, 37}, Reflections.reflectPoint(new int[]{1, -35}, new int[]{-12, 1}));
        assertArrayEquals(new int[]{-1014, -443}, Reflections.reflectPoint(new int[]{1000, 15}, new int[]{-7, -214}));
        assertArrayEquals(new int[]{0, 0}, Reflections.reflectPoint(new int[]{0, 0}, new int[]{0, 0}));
    }

    @Test
    public void testReflectPointSolutionStream() {
        assertArrayEquals(new int[]{2, 2}, Reflections.reflectPointSolutionStream(new int[]{0, 0}, new int[]{1, 1}));
        assertArrayEquals(new int[]{-6, -18}, Reflections.reflectPointSolutionStream(new int[]{2, 6}, new int[]{-2, -6}));

        assertArrayEquals(new int[]{-30, 30}, Reflections.reflectPointSolutionStream(new int[]{10, -10}, new int[]{-10, 10}));
        assertArrayEquals(new int[]{-25, 37}, Reflections.reflectPointSolutionStream(new int[]{1, -35}, new int[]{-12, 1}));
        assertArrayEquals(new int[]{-1014, -443}, Reflections.reflectPointSolutionStream(new int[]{1000, 15}, new int[]{-7, -214}));
        assertArrayEquals(new int[]{0, 0}, Reflections.reflectPointSolutionStream(new int[]{0, 0}, new int[]{0, 0}));
    }
}