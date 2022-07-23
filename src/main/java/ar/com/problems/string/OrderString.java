package ar.com.problems.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class OrderString {

    public static void main(String[] args) {
        System.out.println(getStringOrdererDescending(1795386));
        System.out.println(getKataDescendingOrder(1596274));
        System.out.println(getKataDescendingOrderOption2(1795386));
    }

    private static int getStringOrdererDescending(final int num) {

        String tempStr = String.valueOf(num);

        char[] tempArray = tempStr.toCharArray();

        Arrays.sort(tempArray);
        reverse(tempArray);

        return Integer.valueOf(String.valueOf(tempArray)).intValue();
    }

    private static void reverse(char[] tempArray) {
        int n = tempArray.length;

        for (int i = 0; i < n /2; i++){
            char temp = tempArray[i];
            tempArray[i] = tempArray[n - i -1];
            tempArray[n - i - 1] = temp;
        }
    }

    private static int getKataDescendingOrder(final int number) {
        return Integer.parseInt(String
                .valueOf(number).chars()
                .mapToObj(i -> String.valueOf(Character.getNumericValue(i)))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining()));
    }

    private static int getKataDescendingOrderOption2(final int number) {

       return Integer.parseInt(
               Integer.toString(number).codePoints()
                       .sorted()
                       .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                       .reverse().toString()
       );

    }

}
