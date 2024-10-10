package ar.com.problems.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatePalindromeV2Test {

    @Test
    public void basicTests(){
        assertTrue(CreatePalindromeV2.solve("abba"));
        assertFalse(CreatePalindromeV2.solve("abaazaba"));
        assertTrue(CreatePalindromeV2.solve("abccba"));
        assertTrue(CreatePalindromeV2.solve("adfa"));
        assertFalse(CreatePalindromeV2.solve("ae"));
        assertTrue(CreatePalindromeV2.solve("sq"));
        assertFalse(CreatePalindromeV2.solve("abzy"));
        assertTrue(CreatePalindromeV2.solve("kxbkwgyydkcbtjcosgikfdyhuuprubpwthgflucpyylbofvqxkkvqthmdnywpaunfihvupbwpruwfybdmgeuocltdaidyyewmbzm"));

    }
}