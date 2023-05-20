package ar.com.problems.numbers;

public class RomanNumeralsEncoder {
    private static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public static void main(String[] args) {
        System.out.println(firstSolution(1989));
    }
    private static String firstSolution(int num) {
        StringBuilder romanNumeral = new StringBuilder();

        // Iterate through the symbols and values arrays
        for (int i = 0; i < symbols.length; i++) {
            // Append the symbol while the value is less than or equal to the given number
            while (num >= values[i]) {
                romanNumeral.append(symbols[i]);
                num -= values[i];
            }
        }

        return romanNumeral.toString();
    }

}
