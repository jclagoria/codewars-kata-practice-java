package ar.com.problems.numbers;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class NumberCardinality {

    public static String number_cardinality(int number) {
        // Get the last digit of the number
        int lastDigit = number % 10;

        // Define a map for specific cases
        Map<Integer, String> specificCases = new HashMap<>();
        specificCases.put(0, "zero");
        specificCases.put(5, "five");

        // Define the function to handle general cases
        Function<Integer, String> generalCase = digit -> (digit % 2 == 0) ? "even" : "odd";

        // Apply the appropriate function
        return specificCases.getOrDefault(lastDigit, generalCase.apply(lastDigit));
    }

    public static String number_cardinality_(int number) {
        // Get the last digit of the number
        int lastDigit = number % 10;

        // Define a mapping function for cardinality
        Function<Integer, String> cardinality = digit -> {
            return switch (digit) {
                case 0 -> "zero";
                case 5 -> "five";
                default -> (digit % 2 == 0) ? "even" : "odd";
            };
        };

        // Apply the function to get the result
        return cardinality.apply(lastDigit);
    }


}
