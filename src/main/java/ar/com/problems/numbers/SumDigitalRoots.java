package ar.com.problems.numbers;

import java.util.ArrayList;
import java.util.List;
/**
 * Digital root is the recursive sum of all the digits in a number.

Given n, take the sum of the digits of n. If that value has more than one digit, continue reducing in this way until a single-digit number is produced. The input will be a non-negative integer.


 */

public class SumDigitalRoots {

    private static List<Integer> arrydigits = new ArrayList<>();
    private static int sumDigits = 0;
    
    public static void main(String[] args) {
        System.out.println(returnSumIndividualGigitsInNumber(456)); 
        System.out.println(goodOptionDigitalRootKataSolution(493193));
    }

    private static int returnSumIndividualGigitsInNumber(final int number) {
        
        arraysOfIntegers(number);

        while( arrydigits.size() >= 2) {                       
               

                for (Integer intDigit : arrydigits) {
                    sumDigits += intDigit;
                }
                arrydigits = new ArrayList<>();

                if(sumDigits > 9){
                    arraysOfIntegers(sumDigits);
                    sumDigits = 0;
                }                   

        }

        return sumDigits;        
    }

    private static void arraysOfIntegers(int numberAux) {

        while(numberAux > 0){
            arrydigits.add(0, numberAux%10);
            numberAux /= 10;
        }
    }

    private static int goodOptionDigitalRootKataSolution(int number) {

        while(number > 9) {
            System.out.println("value (number / 10) ---> "+ (number / 10));
            System.out.println("value (number % 10) ---> "+ (number % 10));
            number = (number / 10) + ( number % 10);
        }


        return number;
    }

}
