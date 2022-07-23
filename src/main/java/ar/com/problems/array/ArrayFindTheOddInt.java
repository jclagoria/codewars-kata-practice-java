package ar.com.problems.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 *
 * DESCRIPTION:
 * Given an array of integers, find the one that appears an odd number of times.
 *
 * There will always be only one integer that appears an odd number of times.
 *
 * Examples
 * [7] should return 7, because it occurs 1 time (which is odd).
 * [0] should return 0, because it occurs 1 time (which is odd).
 * [1,1,2] should return 2, because it occurs 1 time (which is odd).
 * [0,1,0,1,0] should return 0, because it occurs 3 times (which is odd).
 * [1,2,2,3,3,3,4,3,3,3,2,2,1] should return 4, because it appears 1 time (which is odd).
 *
 */
public class ArrayFindTheOddInt {

    public static void main(String[] args) {

        int[] example_data = {0,1,0,1,0};
        int[] example_data_2 = {1,2,2,3,3,3,4,3,3,3,2,2,1};

        System.out.println(getOddIntFromArray(example_data));
        System.out.println(getOddIntFromArray(example_data_2));

        System.out.println(getOddIntValueFromArrayUsingStreamReduce(example_data_2));

        System.out.println(getFinOddValueWithXOR(example_data_2));
    }

    private static int getOddIntFromArray(int[] arrayNumber){

        Set<Integer> oddElements = new HashSet<Integer>();

        for (int tempInt: arrayNumber
             ) {
            if(oddElements.contains(tempInt)){
                oddElements.remove(Integer.valueOf(tempInt));
            } else {
                oddElements.add(tempInt);
            }
        }

        Optional<Integer> value = oddElements.stream().findFirst();
        return value.orElse(0).intValue();
    }

    /**
     * Others solutions... and better solutions from here
     */

    private static int getOddIntValueFromArrayUsingStreamReduce(int[] arrayNumber){
        return Arrays.stream(arrayNumber).reduce(0, (x,y) -> x ^ y);
    }


    /**
     * XOR will cancel out everytime you XOR with the same number so 1^1=0
     * but 1^1^1=1 so every pair should cancel out leaving the odd number out
     */
    public static int getFinOddValueWithXOR(int[] A) {
        int odd=0;
        for (int item: A)
            {
                odd = odd ^ item;//
            }

        return odd;
     }




}
