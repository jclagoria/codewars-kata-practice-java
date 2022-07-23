package ar.com.problems.numbers;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SquareEveryDigit {

    public static void main(String[] args) {

        System.out.println(getSqureEverynumber(4567));
        System.out.println(getKataIntSquereDigits(4567));
    }

    private static int getSqureEverynumber(int numero){

        char[] charTermp = Integer.toString(numero).toCharArray();
        StringBuilder tempBUilder = new StringBuilder();

        for (char charTemp: charTermp
             ) {
            int tempInt = Integer.parseInt(String.valueOf(charTemp));
            System.out.println(tempInt);
            tempBUilder.append(tempInt * tempInt);
        }

        return Integer.valueOf(tempBUilder.toString()).intValue();
    }

    private static int getKataIntSquereDigits(int number) {

        return Integer.parseInt(
                String.valueOf(number).chars()
                        .map(x -> Character.getNumericValue((char) x))
                        .map(x -> x * x)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(""))
        );
    }


}
