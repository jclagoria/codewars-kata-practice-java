package ar.com.problems.string;

public class DisovelVowel {

    public static void main(String[] args) {

        oldWay("Mirando al norte con todas las vocales y un murcielago");

    }

    private static void oldWay(String strComment) {

        System.out.println(strComment.replaceAll("[aeiouAEIOU]", ""));

    }

}
