package ar.com.problems.string;

/**
 * Create a function taking a positive integer between 1 and 3999 (both included) as its parameter and returning a string containing the Roman Numeral representation of that integer.
 *
 * Modern Roman numerals are written by expressing each digit separately starting with the leftmost digit and skipping any digit with a value of zero. There cannot be more than 3 identical symbols in a row.
 *
 * In Roman numerals:
 *
 * 1990 is rendered: 1000=M + 900=CM + 90=XC; resulting in MCMXC.
 * 2008 is written as 2000=MM, 8=VIII; or MMVIII.
 * 1666 uses each Roman symbol in descending order: MDCLXVI.
 *
 * Example:
 *    1 -->       "I"
 * 1000 -->       "M"
 * 1666 --> "MDCLXVI"
 *
 */
public class RomanNumeralsEncoder {

    static final String[] thousands = {"", "M", "MM", "MMM"};
    static final String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    static final String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    static final String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    static String encodeNumber(int i) {

        return thousands[i / 1000] +
                hundreds[(i % 1000) / 100] +
                tens[(i % 100) / 10] +
                ones[i % 10];
    }
}
