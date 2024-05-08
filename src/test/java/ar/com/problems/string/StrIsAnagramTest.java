package ar.com.problems.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class StrIsAnagramTest extends BaseTest {

    @Test
    public void isAnagramWithMap() {

        assertEquals(Boolean.TRUE,
                StrIsAnagram.isAnagramWithMap("sasma", "Massa"));

    }

    @Test
    public void isAnagramUsingArrays() {
        assertEquals(Boolean.FALSE,
                StrIsAnagram.isAnagramWithMap("anagramm", "marganaa"));
    }
}