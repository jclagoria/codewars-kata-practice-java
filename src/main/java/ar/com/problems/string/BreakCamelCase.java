package ar.com.problems.string;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BreakCamelCase {

    public static void main(String[] args) {

        System.out.println(getBreackCamelCase("holaCositaLinda"));
        System.out.println(getBreackCamelCase(""));
        System.out.println(getBreackCamelCase("marinera"));

        System.out.println(getKataSolutionBreackCamelCase("holaCositaLinda"));
        System.out.println(getKataSolutionBreackCamelCase(""));
        System.out.println(getKataSolutionBreackCamelCase("marinera"));

    }

    private static String getBreackCamelCase(String camelCaseStr) {

        return Arrays.stream(camelCaseStr.split("(?=[A-Z])")).collect(Collectors.joining(" "));
    }

    private static String getKataSolutionBreackCamelCase(String camelCaseStr) {
        return String.join(" ", camelCaseStr.split("(?=[A-Z])"));
    }

}
