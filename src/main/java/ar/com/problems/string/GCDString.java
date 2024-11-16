package ar.com.problems.string;

/**
 * For two strings s and t, we say "t divides s" if and only if
 * s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or
 * more times).
 *
 * Given two strings str1 and str2, return the largest string x such that
 * x divides both str1 and str2.
  * Example 1:
 *
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * Example 2:
 *
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * Example 3:
 *
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 * Constraints:
 *
 * 1 <= str1.length, str2.length <= 1000
 * str1 and str2 consist of English uppercase letters.
 */
public class GCDString {

    public static String gcdOfString(String str1, String str2) {

        // Calculate GCD of the lengths of str1 and str2
        int len1 = str1.length();
        int len2 = str2.length();
        int gcdLength = gdc(len1, len2);

        // Candidate substring with length gcdLength
        String candidate = str1.substring(0, gcdLength);

        // Check if the candidate can form both str1 and str2 by repeating
        if (isDivisible(str1, candidate) && isDivisible(str2, candidate)) {
            return candidate;
        }

        return ""; // No common divisor string
    }

    // Helper method to check if a string can be formed by repeating a substring
    private static boolean isDivisible(String str, String sub) {
        if (str.length() % sub.length() != 0) {
            return false; // If str's length is not a multiple of sub's length, it can't be divided evenly
        }

        // Repeat sub enough times to match str's length and check equality
        int repeatCount = str.length() / sub.length();
        return sub.repeat(repeatCount).equals(str);
    }

    public static String gcdOfStringsAnotherSolution(String str1, String str2) {

        StringBuilder sb = new StringBuilder();
        sb.append(str1).append(str2);

        StringBuilder sbOption2 = new StringBuilder();
        sbOption2.append(str2).append(str1);

        if (!sb.toString().contentEquals(sbOption2.toString())) {
            return "";
        }

        int gdc = gdc(str1.length(), str2.length());
        return str1.substring(0, gdc);
    }

    // Helper method to calculate gcd
    private static int gdc(int lengthStr1, int lengthStr2) {
        return lengthStr2 == 0 ? lengthStr1 :
                gdc(lengthStr2, lengthStr1 % lengthStr2);
    }
}
