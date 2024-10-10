package ar.com.problems.array;

import java.util.Arrays;
import java.util.List;

public class MixedSum {

    public static void main(String[] args) {

        oldSolution(Arrays.asList(1, "2"));
        streamMapSolution(Arrays.asList(1, "2", 9 , 8, "1", "3"));

    }

    private static void oldSolution(List<?> listElements) {

        int sumValue = 0;

        for (Object listElement : listElements) {

            int evalInt = 0;

            if (listElement instanceof String) {
                evalInt = Integer.parseInt((String) listElement);
            } else
                evalInt = (int) listElement;

            sumValue = sumValue + evalInt;

        }


        System.out.println(sumValue);
    }

    private static void streamMapSolution(List<?> mixedArray) {

        int valueSum = mixedArray.stream()
                .map(Object::toString)
                .map(Integer::valueOf)
                .reduce(0, Integer::sum);

        System.out.println(valueSum);

    }


}
