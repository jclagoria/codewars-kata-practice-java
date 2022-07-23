package ar.com.problems.string;

public class JennySecretMessage {

    private static final String SPECIAL_MESSAGE = "Hello, my love!";
    private static final String SPECIAL_NAME = "Johnny";


    public static void main(String[] args) {

        System.out.println(greet("Jose"));

        System.out.println(greet("Johnny"));

    }

    public static String greet(String name) {
        return name.equals(SPECIAL_NAME) ? SPECIAL_MESSAGE : "Hello, %s!".formatted(name);
    }

}
