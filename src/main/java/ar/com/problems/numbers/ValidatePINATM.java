package ar.com.problems.numbers;

public class ValidatePINATM {

    public static void main(String[] args) {

        System.out.println(validatePin("1234"));
        System.out.println(validatePin("456780"));
        System.out.println(validatePin("45678"));
        System.out.println(validatePin("45678022"));

    }

    private static boolean validatePin(String pin) {

        return pin.matches("\\d{4}|\\d{6}");

    }

}
