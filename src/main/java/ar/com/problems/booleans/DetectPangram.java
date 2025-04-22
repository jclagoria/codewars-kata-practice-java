package ar.com.problems.booleans;

import java.util.HashSet;
import java.util.Set;

/**
 * A pangram is a sentence that contains every single letter of the alphabet at least once. For example,
 * the sentence "The quick brown fox jumps over the lazy dog" is a pangram,
 * because it uses the letters A-Z at least once (case is irrelevant).
 *
 * Given a string, detect whether or not it is a pangram. Return True if it is, False if not. Ignore numbers and punctuation.
 */
public class DetectPangram {

    /**
     * Check if the given sentence is a pangram.
     * A pangram is a sentence that contains every single letter of the alphabet at least once.
     * For example, the sentence "The quick brown fox jumps over the lazy dog" is a pangram,
     * because it uses the letters A-Z at least once (case is irrelevant).
     *
     * The method ignores numbers and punctuation.
     *
     * @param sentence the sentence to check
     * @return true if the sentence is a pangram, false otherwise
     */
    public static boolean check(String sentence) {

        if ( sentence == null ) {
            return false;
        }

        Set<Character> letters = new HashSet<>();

        // iterate through the characters of the sentence
        for (char character : sentence.toLowerCase().toCharArray()) {
            // ignore numbers and punctuation
            if (Character.isLowerCase(character)) {
                // add the character to the set
                letters.add(character);
            }
        }

        // a sentence is a pangram if it contains 26 different letters
        return letters.size() == 26;
    }

    /**
     * A functional version of the check method.
     *
     * @param sentence the sentence to check
     * @return true if the sentence is a pangram, false otherwise
     */
    public static boolean checkFunctional(String sentence) {
        // convert the sentence to a stream of lower case characters
        // filter out non letters
        // make the stream distinct
        // count the characters
        // return true if the count is 26, false otherwise
        return sentence.toLowerCase().chars()
                .filter(Character::isLetter).distinct().count() == 26;
    }


}
