package ar.com.problems.string;

import java.util.regex.Pattern;

public class SimpleStringCharacters {

    public static int[] Solve(String word) {

        int totalLowerCase = 0;
        int totalUpperCase = 0;
        int totalNumbers = 0;
        int totalSpecialCharacters = 0;

        char[] arrayOfChars = word.toCharArray();

        for (char c : arrayOfChars) {
            if(Character.isUpperCase(c)){
                totalUpperCase++;
            } else if(Character.isLowerCase(c)){
                totalLowerCase++;
            } else if(Character.isDigit(c)){
                totalNumbers++;
            } else {
                totalSpecialCharacters++;
            }

        }

        return new int[]{totalUpperCase,totalLowerCase,totalNumbers,totalSpecialCharacters};
    }

    public static int[] solveWithAnotherMethod(String word) {
        return new int[] {
                word.replaceAll("[^A-Z]", "").length(),
                word.replaceAll("[^a-z]", "").length(),
                word.replaceAll("[^0-9]", "").length(),
                word.replaceAll("[\\w]", "").length()
        };
    }
}
