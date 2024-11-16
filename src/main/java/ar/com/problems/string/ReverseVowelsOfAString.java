package ar.com.problems.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, reverse only all the vowels in the string and return it.
 *
 * The vowels are 'a', 'e', 'i', 'o', and 'u',
 * and they can appear in both lower and upper cases, more than once.
 * 
 * Example 1:
 * Input: s = "IceCreAm"
 * Output: "AceCreIm"
 * Explanation:
 * The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".
 *
 * Example 2:
 * Input: s = "leetcode"
 * Output: "leotcede"
 * Constraints:
 *
 * 1 <= s.length <= 3 * 105
 * s consist of printable ASCII characters.
 */
public class ReverseVowelsOfAString {

    public static String reverseVowels(String s) {
        // Define a set of vowels for fast lookup
        Set<Character> vowels = new HashSet<>();
        for (char c : "aeiouAEIOU".toCharArray()) {
            vowels.add(c);
        }

        // Convert the string to a character array to allow in-place swaps
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            // Move left pointer to the next vowel
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }
            // Move right pointer to the previous vowel
            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }
            // Swap vowels at left and right pointers
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            // Move pointers inward
            left++;
            right--;
        }

        // Convert char array back to a string and return
        return new String(chars);
    }

}
