package ar.com.problems.numbers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Welcome. In this kata, you are asked to square every digit of a number and concatenate them.
 * For example, if we run 9119 through the function, 811181 will come out, because 92 is 81 and 12 is 1. (81-1-1-81)
 * Example #2: An input of 765 will/should return 493625 because 72 is 49, 62 is 36, and 52 is 25. (49-36-25)
 * Note: The function accepts an integer and returns an integer.
 * Happy Coding!
 */
public class SquareDigit {

    public static int squareDigits(int n) {

        char[] charValue = String.valueOf(n).toCharArray();
        StringBuilder squareStr = new StringBuilder();

        for (char c : charValue) {
            int intValue = Character.getNumericValue(c);
            squareStr.append(intValue * intValue);
        }

        return Integer.parseInt(squareStr.toString());
    }

    public static int squareDigitsStream(int n) {

        return Integer
                .parseInt(String.valueOf(n).chars()
                        .mapToObj(charInt ->
                                String.valueOf(
                                        Character.getNumericValue(charInt) * Character.getNumericValue(charInt)
                                ))
                        .collect(Collectors.joining()));
    }

}
