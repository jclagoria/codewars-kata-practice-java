package ar.com.problems.numbers;

public class StringToNumber {

    public static void main(String[] args) {

        System.out.println(convertStringToInt("99981"));
        System.out.println(convertStringToInt("-8994"));

    }

    private static int convertStringToInt(String str){

        return Integer.valueOf(str);

    }


}
