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

        // Create frequency maps for characters in both strings
        Map<Character, Integer> freqMapA = new HashMap<>();
        Map<Character, Integer> freqMapB = new HashMap<>();

        // Populate frequency map for string a
        for (int i = 0; i < strA.length(); i++) {
            char ch = strA.charAt(i);
            freqMapA.put(ch, freqMapA.getOrDefault(ch, 0) + 1);
        }

        // Populate frequency map for string b
        for (int i = 0; i < strB.length(); i++) {
            char ch = strB.charAt(i);
            freqMapB.put(ch, freqMapB.getOrDefault(ch, 0) + 1);
        }

        // Compare the frequency maps
        return freqMapA.equals(freqMapB);
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
