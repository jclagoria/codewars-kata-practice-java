package ar.com.problems.string;

import java.util.Scanner;

/**
 * A palindrome is a word, phrase, number, or other sequence of characters which reads the same backward or forward.
 *
 * Given a string , print Yes if it is a palindrome, print No otherwise.
 *
 * Constraints
 *
 *  will consist at most  lower case english letters.
 * Sample Input
 *
 * madam
 * Sample Output
 *
 * Yes
 */
public class Palindromo {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String strEntered=sc.next();

        System.out.println(isPalindrome(strEntered) ? "Yes" : "No");

        sc.close();
    }

    public static boolean isPalindrome(String str) {
        return new StringBuilder(str).reverse().toString().equals(str);
    }

}
