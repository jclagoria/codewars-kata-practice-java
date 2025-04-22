package ar.com.problems.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FriendOrFoeTest {

    @Test
    void testBasicExamples() {
        List<String> input1 = Arrays.asList("Ryan", "Kieran", "Jason", "Yous");
        List<String> expected1 = Arrays.asList("Ryan", "Yous");
        assertEquals(expected1, FriendOrFoe.friend(input1));

        List<String> input2 = Arrays.asList("Peter", "Stephen", "Joe");
        List<String> expected2 = Collections.emptyList();
        assertEquals(expected2, FriendOrFoe.friend(input2));
    }

    @Test
    void testAllFourLetterNames() {
        List<String> input = Arrays.asList("Anna", "Mark", "John", "Sara");
        List<String> expected = List.copyOf(input);
        assertEquals(expected, FriendOrFoe.friend(input));
    }

    @Test
    void testEmptyList() {
        List<String> input = Collections.emptyList();
        List<String> expected = Collections.emptyList();
        assertEquals(expected, FriendOrFoe.friend(input));
    }

    @Test
    void testMixedLengthNames() {
        List<String> input = Arrays.asList("A", "BB", "CCC", "DDDD", "EEEEE");
        List<String> expected = Arrays.asList("DDDD");
        assertEquals(expected, FriendOrFoe.friend(input));
    }




    @Test
    void testBasicExamplesStream() {
        List<String> input1 = Arrays.asList("Ryan", "Kieran", "Jason", "Yous");
        List<String> expected1 = Arrays.asList("Ryan", "Yous");
        assertEquals(expected1, FriendOrFoe.friendStream(input1));

        List<String> input2 = Arrays.asList("Peter", "Stephen", "Joe");
        List<String> expected2 = Collections.emptyList();
        assertEquals(expected2, FriendOrFoe.friendStream(input2));
    }

    @Test
    void testAllFourLetterNamesStream() {
        List<String> input = Arrays.asList("Anna", "Mark", "John", "Sara");
        List<String> expected = List.copyOf(input);
        assertEquals(expected, FriendOrFoe.friendStream(input));
    }

    @Test
    void testEmptyListStream() {
        List<String> input = Collections.emptyList();
        List<String> expected = Collections.emptyList();
        assertEquals(expected, FriendOrFoe.friendStream(input));
    }

    @Test
    void testMixedLengthNamesStream() {
        List<String> input = Arrays.asList("A", "BB", "CCC", "DDDD", "EEEEE");
        List<String> expected = Arrays.asList("DDDD");
        assertEquals(expected, FriendOrFoe.friendStream(input));
    }

    @Test
    public void testEmptyInput() {
        List<String> result = FriendOrFoe.friendLambda();
        assertTrue(result.isEmpty());
    }
    @Test
    public void testSingleNameWith4Characters() {
        List<String> result = FriendOrFoe.friendLambda("John");
        assertEquals(1, result.size());
        assertEquals("John", result.get(0));
    }
    @Test
    public void testSingleNameWithLessThan4Characters() {
        List<String> result = FriendOrFoe.friendLambda("Jon");
        assertTrue(result.isEmpty());
    }
    @Test
    public void testSingleNameWithMoreThan4Characters() {
        List<String> result = FriendOrFoe.friendLambda("Johnny");
        assertTrue(result.isEmpty());
    }
    @Test
    public void testMultipleNamesWith4Characters() {
        List<String> result = FriendOrFoe.friendLambda("John", "Mark", "Luke");
        assertEquals(3, result.size());
        assertEquals("John", result.get(0));
        assertEquals("Mark", result.get(1));
        assertEquals("Luke", result.get(2));
    }
    @Test
    public void testMultipleNamesWithLessThan4Characters() {
        List<String> result = FriendOrFoe.friendLambda("Jon", "Mar", "Lu");
        assertTrue(result.isEmpty());
    }
    @Test
    public void testMultipleNamesWithMoreThan4Characters() {
        List<String> result = FriendOrFoe.friendLambda("Johnny", "Markus", "Lucas");
        assertTrue(result.isEmpty());
    }
    @Test
    public void testMixedNamesWith4CharactersAndOtherLengths() {
        List<String> result = FriendOrFoe.friendLambda("John", "Jon", "Mark", "Johnny", "Luke");
        assertNotEquals(2, result.size());
        assertEquals("John", result.get(0));
        assertEquals("Mark", result.get(1));
    }


}