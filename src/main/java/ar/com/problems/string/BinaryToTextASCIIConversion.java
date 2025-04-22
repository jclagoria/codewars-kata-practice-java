package ar.com.problems.string;

import java.util.stream.IntStream;

/**
 * Write a function that takes in a binary string and returns the equivalent decoded text (the text is ASCII encoded).
 *
 * Each 8 bits on the binary string represent 1 character on the ASCII table.
 *
 * The input string will always be a valid binary string.
 *
 * Characters can be in the range from "00000000" to "11111111" (inclusive)
 *
 * Note: In the case of an empty binary string your function should return an empty string.
 */
public class BinaryToTextASCIIConversion {

    /**
     * Converts a binary string to its equivalent decoded text (ASCII encoded).
     *
     * @param binary the binary string to decode
     * @return the decoded text
     */
    public static String binaryToText(String binary) {
        // Check if the binary string is empty
        if (binary == null || binary.isEmpty()) return "";

        // Check if the length of the binary string is a multiple of 8
        int length = binary.length();
        if (length % 8 != 0) {
            throw new IllegalArgumentException("Binary string length must be a multiple of 8");
        }

        // Initialize an array to store the decoded characters
        char[] chars = new char[length / 8];
        int charIndex = 0;
        int binaryIndex = 0;

        // Decode the binary string to text
        while (binaryIndex < length) {
            int asciiValue = 0;
            for (int i = 0; i < 8; i++) {
                asciiValue = (asciiValue << 1) + (binary.charAt(binaryIndex++) - '0');
            }
            chars[charIndex++] = (char) asciiValue;
        }

        // Return the decoded text
        return new String(chars);
    }

    /**
     * Converts a binary string to its equivalent decoded text (ASCII encoded) using functional programming.
     *
     * @param binary the binary string to decode
     * @return the decoded text
     * @throws IllegalArgumentException if the binary string length is not a multiple of 8
     */
    public static String binaryToTextFP(String binary) {
        // Check if the binary string is empty
        if (binary == null || binary.isEmpty()) return "";

        // Check if the length of the binary string is a multiple of 8
        if (binary.length() % 8 != 0) {
            throw new IllegalArgumentException("Binary string length must be a multiple of 8");
        }

        // Convert binary string to ASCII text using stream
        return IntStream.range(0, binary.length() / 8)
                .mapToObj(i -> binary.substring(i * 8, i * 8 + 8)) // Divide the string into 8-bit segments
                .map(b -> (char) Integer.parseInt(b, 2)) // Convert each 8-bit segment to a character
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString(); // Collect into a StringBuilder and convert to String
    }


}
