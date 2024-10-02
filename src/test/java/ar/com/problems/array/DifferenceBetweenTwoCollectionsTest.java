package ar.com.problems.array;

import ar.com.problems.string.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DifferenceBetweenTwoCollectionsTest extends BaseTest {

    @Test
    public void diff() {

        assertEquals("should return empty for the same content",
                list(),
                DifferenceBetweenTwoCollections.diff(list('a', 'b'), list('a', 'b')));
        assertEquals("should return A if B is empty",
                list('a', 'b'),
                DifferenceBetweenTwoCollections.diff(list('a', 'b'), list()));
        assertEquals("should return B if A is empty",
                list('a', 'b'), DifferenceBetweenTwoCollections.diff(list(),
                        list('a', 'b')));
        assertEquals("should return empty for the empty content", list(),
                DifferenceBetweenTwoCollections.diff(list(), list()));
        assertEquals("should return the last character",          list('z'),
                DifferenceBetweenTwoCollections.diff(list('a', 'b', 'z'), list('a', 'b')));
        assertEquals("should return the sorted characters",       list('d', 'e', 'j', 'z'),
                DifferenceBetweenTwoCollections.diff(list('a', 'b', 'z', 'd', 'e', 'd'),
                        list('a', 'b', 'j', 'j')));

    }


    private List<Character> list(char... elements) {
        ArrayList<Character> list = new ArrayList<>();
        for (char s : elements) {
            list.add(s);
        }
        return list;
    }
}