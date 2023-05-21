package ar.com.problems.numbers;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Math.pow;
import static java.util.stream.Collectors.joining;

/**
 * Write Number in Expanded Form
 * You will be given a number and you will need to return it as a string in Expanded Form. For example:
 *
 * Kata.expandedForm(12); # Should return "10 + 2"
 * Kata.expandedForm(42); # Should return "40 + 2"
 * Kata.expandedForm(70304); # Should return "70000 + 300 + 4"
 * NOTE: All numbers will be whole numbers greater than 0.
 */
public class WriteNumberExpandedForm {
    public static void main(String[] args) {

        System.out.println(expandedForm(3021));
        System.out.println(expandedFormIntStream(900000));

    }

    private static String expandedForm(int num) {

        List<Integer> numValues = new ArrayList<>();

        while(num > 0){
            numValues.add(0, num%10);
            num = num / 10;
        }
        var numOfZeros = numValues.size();

        StringBuffer expandedFormStr = new StringBuffer();

        for (Integer value: numValues
             ) {
            expandedFormStr
                    .append(value.intValue() > 0 ? StringUtils.rightPad(value.toString(), numOfZeros, '0') : "");
            if((value.intValue() > 0)){
                expandedFormStr.append(" + ");
            }
            numOfZeros -= 1;
        }

        String value = StringUtils.removeEnd(expandedFormStr.toString().trim(), "+").trim();

        return  value;
    }

    private static String expandedFormIntStream(int num) {
        String strNum = String.valueOf(num);

        return IntStream.range(0, strNum.length())
                .filter(i -> strNum.charAt(i) != '0')
                .map(i -> Character.getNumericValue(strNum.charAt(i))
                        * (int) pow(10, strNum.length() - (i + 1))
                )
                .mapToObj(String::valueOf)
                .collect(joining(" + "));
    }

}
