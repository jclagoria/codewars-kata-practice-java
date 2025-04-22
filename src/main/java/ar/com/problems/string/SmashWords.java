package ar.com.problems.string;

/**
 * Sentence Smash
 * Write a function that takes an array of words and smashes them together into a sentence and returns the sentence.
 * You can ignore any need to sanitize words or add punctuation, but you should add spaces between each word.
 * Be careful, there shouldn't be a space at the beginning or the end of the sentence!
 *
 * Example
 * ['hello', 'world', 'this', 'is', 'great']  =>  'hello world this is great'
 */
public class SmashWords {

    /**
     * Returns a sentence composed by the given words separated by spaces.
     * There shouldn't be a space at the beginning or the end of the sentence.
     * @param words the words to be joined
     * @return the sentence
     */
    public static String smash(String... words) {
        return String.join(" ", words);
    }


    /**
     * Returns a sentence composed by the given words separated by spaces.
     * There shouldn't be a space at the beginning or the end of the sentence.
     * @param words the words to be joined
     * @return the sentence
     */
    public static String smashBuilder(String... words) {
        StringBuilder sb = new StringBuilder();
        // iterate through all the words
        for (String word : words)
        {
            // append each word to the StringBuilder
            sb.append(word).append(" ");
        }
        // remove the last space with trim() and return the sentence
        return sb.toString().trim();
    }

}
