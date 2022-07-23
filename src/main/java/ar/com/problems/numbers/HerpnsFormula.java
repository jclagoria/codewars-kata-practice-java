package ar.com.problems.numbers;

import javax.sound.midi.Soundbank;
import java.util.function.BiFunction;
import java.util.function.Function;

public class HerpnsFormula {


    public static void main(String[] args) {

        System.out.println(heronsFormula(8,4,6));

    }

    private static double heronsFormula(int operatorA, int operatorB, int operatorC) {

        int valueSemiPerimeter = calculateSemiPerimeter(operatorA, operatorB, operatorC);
        System.out.println(valueSemiPerimeter);

        BiFunction<Integer, Integer, Integer> restFormula = (a, b) -> a - b;
        BiFunction<Integer, Integer, Integer> multiplyFormula = (a, b) -> a * b;

        Function<Integer, Double> formula = value -> Math.sqrt(value);

        int valueA = multiplyFormula.apply(valueSemiPerimeter,
                restFormula.apply(valueSemiPerimeter, operatorA));
        int valueB = multiplyFormula.apply(restFormula.apply(valueSemiPerimeter, operatorB),
                restFormula.apply(valueSemiPerimeter, operatorC));

        return formula.apply(multiplyFormula.apply(valueA, valueB));
    }

    private static int calculateSemiPerimeter(int operatorA, int operatorB, int operatorC) {

        BiFunction<Integer, Integer, Integer> sumFunction = (a, b) -> a + b;
        BiFunction<Integer, Integer, Integer> divisionFuntion = (a, b) ->  a / b;


        return divisionFuntion.apply(sumFunction
                .apply(sumFunction
                        .apply(operatorA,operatorB), operatorC), 2);

    }



}
