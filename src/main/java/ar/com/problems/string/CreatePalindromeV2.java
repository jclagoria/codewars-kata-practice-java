package ar.com.problems.string;

/**
 * Consider the string "adfa" and the following rules:
 * a) each character MUST be changed either to the one before or the one after in alphabet.
 * b) "a" can only be changed to "b" and "z" to "y".
 * From our string, we get:
 *
 * "adfa" -> ["begb","beeb","bcgb","bceb"]
 *
 * Here is another example:
 * "bd" -> ["ae","ac","ce","cc"]
 *
 * --We see that in each example, one of the outcomes is a palindrome. That is, "beeb" and "cc".
 * You will be given a lowercase string and your task is to return True if at least one of the outcomes is a palindrome or False otherwise.
 *
 * More examples in test cases. Good luck!
 *
 * public static boolean solve(String st) {
 *         //..
 *     }
 *
 */
public class CreatePalindromeV2 {

    public static boolean solve(String word) {
        return canTransformToPalindrome(word);
    }

    // This method checks if the string can be transformed into a palindrome
    private static boolean canTransformToPalindrome(String wordToValidate) {
        int lengthOfWord = wordToValidate.length();

        if (lengthOfWord == 0) {
            return true;  // Empty string is trivially a palindrome
        }

        // Compare characters from both ends of the string
        for (int i = 0; i < lengthOfWord / 2; i++) {
            char leftChar = wordToValidate.charAt(i);
            char rightChar = wordToValidate.charAt(lengthOfWord - 1 - i);

            // Skip if both characters are already the same
            if (leftChar == rightChar) {
                continue;
            }

            // Check if the characters can be transformed into each other
            if (!canTransform(leftChar, rightChar)) {
                return false;
            }
        }
        return true;
    }

    // Helper method to check if two characters can transform into each other
    private static boolean canTransform(char left, char right) {
        // Characters can transform if they are the same or adjacent in the alphabet
        return left == right || Math.abs(left - right) == 1;
    }
}
