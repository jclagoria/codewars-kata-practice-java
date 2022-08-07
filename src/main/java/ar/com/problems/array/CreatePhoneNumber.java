package ar.com.problems.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 
 * DESCRIPTION:
 *   Write a function that accepts an array of 10 integers (between 0 and 9), that returns a string of those numbers in the form of a phone number.
 *
 *    Example
 *    Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}) // => returns "(123) 456-7890"
 *    The returned format must be correct in order to complete this challenge.
 *   Don't forget the space after the closing parentheses!
 *  
 */
public class CreatePhoneNumber {
    
    private static String PHONE_FORMAT = "(%d%d%d) %d%d%d-%d%d%d%d";

    public static void main(String[] args) {
        System.out.println(recoverPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
        System.out.println(betterOPtionToObtainAPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }

    private static String recoverPhoneNumber(int[] arrayPhoneNumber) {

        List<Integer> listPhoneNumber = Arrays
                                .stream(arrayPhoneNumber)
                                .boxed()
                                .collect(Collectors.toList());
        
        StringBuilder stringPhoneNumber = new StringBuilder();
        stringPhoneNumber.append("(")
            .append(getPhoneNumberString(listPhoneNumber, 0, 3))
            .append(") ")
            .append(getPhoneNumberString(listPhoneNumber, 3, 6))
            .append("-")
            .append(getPhoneNumberString(listPhoneNumber, 6, listPhoneNumber.size()));

        return stringPhoneNumber.toString();
    }

    private static String getPhoneNumberString(List<Integer> subList, int initSubIndex, int lastSubIndex){

        StringBuilder partPhoneNumber = new StringBuilder();

        subList.subList(initSubIndex, lastSubIndex)
            .forEach(partPhoneNumber::append);

        return partPhoneNumber.toString();

    }

    /**
     * 
     * 
     * @param arrayPhoneNumber
     * @return
     */
    private static String betterOPtionToObtainAPhoneNumber(int[] arrayPhoneNumber) {

        return String.format(PHONE_FORMAT, 
                    IntStream.of(arrayPhoneNumber).boxed().toArray());
    }


}
