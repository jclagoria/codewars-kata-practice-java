package ar.com.problems.string;

/**
 * Given a string of digits, you should replace any digit below 5 with '0'
 * and any digit 5 and above with '1'. Return the resulting string.
 *
 * Note: input will never be an empty string
 */
public class FakeBinary {

    /**
     * Replaces any digit below 5 with '0' and any digit 5 and above with '1'.
     * @param numberString the string of digits to process
     * @return the resulting string
     */
    public static String fakeBin(String numberString) {
        // Create a StringBuilder to build the output string
        StringBuilder sb = new StringBuilder(numberString.length());

        // Iterate over the characters in the string
        for (char character : numberString.toCharArray()) {
            // Replace any digit below 5 with '0' and any digit 5 and above with '1'
            sb.append(character < '5' ? '0' : '1');
        }

        // Return the resulting string
        return sb.toString();
    }

    /**
     * A functional version of the fakeBin method.
     * @param s the string of digits to process
     * @return the resulting string
     */
    public static String fakeBingFunctional(String s) {
        // Use a StringBuilder to build the output string
        return s.chars()
                // Iterate over the characters in the string
                .collect(
                        // Create a StringBuilder and append the first character
                        StringBuilder::new,
                        // Append the next character to the StringBuilder
                        (sb, ch) -> sb.append(ch < '5' ? '0' : '1'),
                        // Append the strings from different threads
                        StringBuilder::append
                ).toString();
    }


}
