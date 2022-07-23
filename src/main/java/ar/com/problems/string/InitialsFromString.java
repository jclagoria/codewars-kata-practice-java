package ar.com.problems.string;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InitialsFromString {

    public static void main(String[] args) {

        System.out.println(kataString("Jose Alberto"));
        System.out.println(kataString("mariana nanis"));
        System.out.println(abbrevNameWithArray("Jose maria Albertina"));
        System.out.println(abbrevNameWithReplace("Juan Carlos Lagoria"));
    }

    private static String kataString(String name){

        String[] strArray = name.split(" ");

        StringBuilder cadenaBuilder = new StringBuilder();

        for (int i = 0; i < strArray.length; i++) {
            cadenaBuilder.append(strArray[i].substring(0,1).toUpperCase()).append(".");
        }

        return cadenaBuilder.substring(0, cadenaBuilder.toString().lastIndexOf("."));
    }

    private static String abbrevNameWithArray(String name) {

        return Arrays.stream(name.split(" "))
                .map(String::toUpperCase)
                .map(word -> word.substring(0,1))
                .collect(Collectors.joining("."));
    }

    private static String abbrevNameWithReplace(String name) {
        return name.toUpperCase().replaceAll("(.).*\\s(.).*", "$1.$2");
    }


}
