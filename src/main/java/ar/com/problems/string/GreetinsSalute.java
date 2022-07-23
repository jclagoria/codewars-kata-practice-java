package ar.com.problems.string;

public class GreetinsSalute {

    public static void main(String[] args) {

        System.out.println(createGreetingsSaluteOld("Jose"));
        System.out.println(concatNameToSaluteBetterWay("Manuel"));
    }

    private static String createGreetingsSaluteOld(String name){

        final String salute = "Hello, ";
        final String restOfMEssage = " how are you doing today?";

        StringBuilder message = new StringBuilder();

        return message.append(salute).append(name).append(restOfMEssage).toString();
    }

    private static String concatNameToSaluteBetterWay(String name) {
        return String.format("Hello, %s how are you doing today?", name);
    }


}
