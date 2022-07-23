package ar.com.problems.string;

import java.util.regex.Pattern;

public class FindVowelsInStr {

    public static void main(String[] args) {
        System.out.println(getNumbOfVowelsInStr("Hola Luke Yo Soy TU PAdre!"));
        System.out.println(getNumOfVowelInStrReplace("Que PaSo ChAval!"));

    }

    private static int getNumbOfVowelsInStr(String str) {

        return (int) str.chars().mapToObj(c -> (char)c)
                .filter(c -> Pattern.compile("[aAeEiIoOuU]")
                        .matcher(String.valueOf(c)).matches())
                .count();
    }

    private static int getNumOfVowelInStrReplace(String str){
        return str.replaceAll("[^aAeEiIoOuU]", "").length();
    }

}
