package ar.com.problems.string;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Replace every letter with a two digit number. The first digit is the row number,
 * and the second digit is the column number of following square. Letters 'I' and 'J' are both 24 in this cipher:
 */
public class PolybiusSquareCipherEncode {

    private static final Map<Character, String> POLYBIUS_MAP = createMap();

    /**
     * Creates a Map that maps each character in the alphabet to its Polybius coordinates.
     * <p>
     * The coordinates are in the form of a string with two digits, the first digit is the row and the second digit is the column.
     * <p>
     * The Polybius Square is a 5x5 matrix with the letters of the alphabet in each cell, with the exception of the letter 'J' which is
     * not included.
     * <p>
     * The Map is ordered so that the characters in the alphabet are in the same order as they appear in the Polybius Square.
     *
     * @return a Map of characters to Polybius coordinates
     */
    private static Map<Character, String> createMap() {

        String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";

        Map<Character, String> polybiusMap = IntStream
                .range(0, alphabet.length())
                .boxed()
                .collect(Collectors.toMap(
                        i -> alphabet.charAt(i),
                        i -> {
                            int row = i / 5 + 1;
                            int col = i % 5 + 1;
                            return String.format("%d%d", row, col);
                        }
                ));

        // 'J' is not included in the Polybius Square, so we add it manually
        polybiusMap.put('J', polybiusMap.get('I'));

        return polybiusMap;
    }

    /**
     * Encodes a given text using the Polybius Square cipher.
     *
     * @param text the input text to be encoded
     * @return the encoded text as a string of Polybius coordinates
     */
    public static String polybius(String text) {
        // StringBuilder to construct the encoded text
        StringBuilder out = new StringBuilder(text.length() * 2);

        // Iterate over each character in the input text
        for (char character : text.toCharArray()) {
            if (character == ' ') {
                // Append a space for space characters in the input text
                out.append(" ");
            } else {
                // Append the corresponding Polybius coordinates for each character
                out.append(POLYBIUS_MAP.get(character));
            }
        }

        // Return the encoded text
        return out.toString();
    }


}
