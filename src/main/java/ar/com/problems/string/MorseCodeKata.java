package ar.com.problems.string;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MorseCodeKata {

    public static final String WORD_DELIMITER = "   ";
    public static final String CHAR_DELIMITER = " ";

    public static void main(String[] args) {

    }

    public static String decode(String morseCode) {
        return Arrays.stream(morseCode.trim().split(WORD_DELIMITER))
                .map(MorseCodeKata::decodeWord)
                .collect(Collectors.joining(" "));
    }

    private static String decodeWord(String morseWord) {
        return null; //Arrays.stream(morseWord.trim().split(CHAR_DELIMITER)).map(MorseCode::get).collect(Collectors.joining());
    }
}
