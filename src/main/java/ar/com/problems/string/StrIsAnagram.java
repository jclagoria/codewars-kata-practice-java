package ar.com.problems.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StrIsAnagram {

    static boolean isAnagramWithMap(String strA, String strB) {

        // Convert the strings to lowercase for case-insensitive comparison
        strA = strA.toLowerCase();
        strB = strB.toLowerCase();

        // If the lengths of the strings are different, they can't be anagrams
        if (strA.length() != strB.length()) {
            return false;
        }

        int[] count = new int[256]; // ASCII size

        // Populate frequency map for string a
        for (int i = 0; i < strA.length(); i++) {
            count[strA.charAt(i)]++;
        }

        // Check if the characters in string b are in the frequency map
        for (int i = 0; i < strB.length(); i++) {
            if (--count[strB.charAt(i)] < 0) {
                return false;
            }
        }

        return true;
    }

    static boolean isAnagramUsingArrays(String strA, String strB) {
        // Convert the strings to lowercase for case-insensitive comparison
        strA = strA.toLowerCase();
        strB = strB.toLowerCase();

        // Convert the strings to char arrays and sort them
        char[] charArrayA = strA.toCharArray();
        char[] charArrayB = strB.toCharArray();
        Arrays.sort(charArrayA);
        Arrays.sort(charArrayB);

        // Compare the sorted char arrays
        return Arrays.equals(charArrayA, charArrayB);
    }

}
