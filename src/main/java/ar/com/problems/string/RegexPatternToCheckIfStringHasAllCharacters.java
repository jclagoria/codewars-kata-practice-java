package ar.com.problems.string;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Task:
 * Your function should return a valid regular expression. This is a pattern which is normally used
 * to match parts of a string. In this case will be used to check if all the
 * characters given in the input appear in a string.
 *
 * Input
 * Non empty string of unique alphabet characters upper and lower case.
 *
 * Output
 * Regular expression pattern string.
 *
 * Examples
 * Your function should return a string.
 *
 * public static String regexContainsAll(str) {
 *   return "abc";
 * }
 * That regex pattern will be tested like this.
 *
 * String abc = "abc";
 * String pattern = regexContainsAll(abc);
 * String str = "zzzaaacccbbbzzz";
 * Pattern.compile(pattern).matcher(str).find();  // -> true
 */
public class RegexPatternToCheckIfStringHasAllCharacters {

    /**
     * Generates a regular expression pattern to check if all characters in the given
     * string appear in another string.
     *
     * @param str the input string containing unique alphabet characters
     * @return a regular expression pattern string
     */
    public static String regexContainsAll(String str) {
        // StringBuilder to construct the regex pattern
        StringBuilder pattern = new StringBuilder();

        // Iterate over each character in the input string
        for (char ch : str.toCharArray()) {
            // Append a positive lookahead to ensure each character is present
            pattern.append("(?=.*").append(Pattern.quote(String.valueOf(ch))).append(")");
        }

        // Append .* to match the entire string
        pattern.append(".*");

        // Return the constructed regex pattern
        return pattern.toString();
    }

    /**
     * Generates a regular expression pattern in a one-liner style to check if all characters
     * in the given string appear in another string.
     *
     * @param str the input string containing unique alphabet characters
     * @return a regular expression pattern string
     */
    public static String regexContainsAllOneLinerStyle(String str) {
        // Split the input string into individual characters, map each character to a positive lookahead,
        // and join them to form the regex pattern, appending ".*" to match the entire string.
        return Arrays.stream(str.split(""))
                .map(c -> "(?=.*" + Pattern.quote(c) + ")")
                .collect(Collectors.joining()) + ".*";
    }

}
