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

        for (int i = 0; i < listElements.size(); i++) {

            int evalInt = 0;

            if(listElements.get(i) instanceof String){
                evalInt = Integer.parseInt((String) listElements.get(i));
            } else
                evalInt = (int) listElements.get(i);

            sumValue = sumValue + evalInt;

        }


        System.out.println(sumValue);
    }

    private static void streamMapSolution(List<?> mixedArray) {

        int valueSum = mixedArray.stream()
                .map(Object::toString)
                .map(Integer::valueOf)
                .reduce(0, (a , b) -> a + b);

        System.out.println(valueSum);

    }


}
