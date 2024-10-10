package ar.com.problems.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatePalindromeTest {

    @Test
    public void basicTests(){
        assertTrue(CreatePalindrome.solve("abba"));
        assertFalse(CreatePalindrome.solve("abaazaba"));
        assertTrue(CreatePalindrome.solve("abccba"));
        assertTrue(CreatePalindrome.solve("adfa"));
        assertFalse(CreatePalindrome.solve("ae"));
        assertTrue(CreatePalindrome.solve("sq"));
        assertFalse(CreatePalindrome.solve("abzy"));
        assertTrue(CreatePalindrome.solve("kxbkwgyydkcbtjcosgikfdyhuuprubpwthgflucpyylbofvqxkkvqthmdnywpaunfihvupbwpruwfybdmgeuocltdaidyyewmbzm"));

    }
}