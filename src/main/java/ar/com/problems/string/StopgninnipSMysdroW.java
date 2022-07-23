package ar.com.problems.string;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StopgninnipSMysdroW {

    public static void main(String[] args) {

        System.out.println(getSoinningStr("dale vueltas a estas palabras"));
        System.out.println(getSecondSolutionKataBestApprouch("dale vueltas a estas palabras"));
        System.out.println(getAnotherOptionFosSpinningStr("dale vueltas a estas palabras"));
        System.out.println(getStringSpinnigFrace("dale vueltas a estas palabras"));

    }

    private static String getSoinningStr(String message) {

        StringBuilder finalString = new StringBuilder();

        for (String valueTemp: message.split(" ")
             ) {

            if(valueTemp.length() > 4){
                StringBuilder temBuilder = new StringBuilder();
                temBuilder.append(valueTemp).reverse();
                finalString.append(temBuilder.toString()).append(" ");
            } else {
                finalString.append(valueTemp).append(" ");
            }
        }

        return finalString.toString().trim();
    }

    private static String getSecondSolutionKataBestApprouch(String sentence) {

        String[] arrayStr = sentence.split(" ");

        for (int i = 0; i < arrayStr.length; i++) {
            if(arrayStr[i].length() > 4){
                arrayStr[i] = new StringBuilder(arrayStr[i]).reverse().toString();
            }
        }

        return String.join(" ", arrayStr);
    }

    private static String getAnotherOptionFosSpinningStr(String senntence){

        for (String tempStr: senntence.split(" ")
             ) {

            if(tempStr.length() > 4) {
                senntence = senntence.replace(tempStr,
                        new StringBuilder(tempStr).reverse());
            }

        }

        return senntence;
    }

    private static String getStringSpinnigFrace(String sentence) {

        return Arrays.stream(sentence.split(" "))
                .map(strTmp -> (strTmp.length() > 4) ? new StringBuffer(strTmp).reverse().toString():strTmp)
                .collect(Collectors.joining(" "));
    }

    private static String getStringSpinningQithStringUtils(String sentence){
        return Arrays.stream(sentence.split(" "))
                .map(tempStr -> (tempStr.length() > 4) ?
                        StringUtils.reverse(tempStr): tempStr)
                .collect(Collectors.joining(" "));
    }


}