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
public class CreatePalindrome {

    public static boolean solve(String word) {
        return isPalindrome(word);
    }

    // This method checks if the string can be transformed into a palindrome
    private static boolean isPalindrome(String wordToValidate) {
        int lengthOfWord = wordToValidate.length();

        // Compare characters from both ends of the string
        for (int i = 0; i < lengthOfWord / 2; i++) {
            char leftChar = wordToValidate.charAt(i);
            char rightChar = wordToValidate.charAt(lengthOfWord - 1 - i);

            // Get the possible transformations for both characters
            int[] leftTransformations = getPossibleTransformations(leftChar);
            int[] rightTransformations = getPossibleTransformations(rightChar);

            // Check if any of the transformations for the left char match those of the right char
            if (!canTransform(leftTransformations, rightTransformations)) {
                return false;
            }
        }
        return true;
    }

    // Helper method to check if two characters can transform into each other
    private static boolean canTransform(int[] first, int[] second) {
        // Compare all transformations from both sets
        return (first[0] == second[0]) || (first[0] == second[1]) ||
                (first[1] == second[0]) || (first[1] == second[1]);
    }

    // Get the possible transformations for a given character
    private static int[] getPossibleTransformations(char character) {
        int[] transformations = new int[2];

        if (character == 'a') {
            transformations[0] = 'b';
            transformations[1] = 'b';  // No backward transformation for 'a', use 'b'
        } else if (character == 'z') {
            transformations[0] = 'y';
            transformations[1] = 'y';  // No forward transformation for 'z', use 'y'
        } else {
            transformations[0] = character - 1;  // Previous character
            transformations[1] = character + 1;  // Next character
        }

        return transformations;
    }
}
