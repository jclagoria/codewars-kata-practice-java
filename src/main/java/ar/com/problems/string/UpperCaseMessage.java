package ar.com.problems.string;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class UpperCaseMessage {

    public static void main(String[] args) {

        System.out.println(messajeJaden("How can mirrors be real if our eyes aren't real"));
        System.out.println(messageJadenWithOptional("How can mirrors be real if our eyes aren't real"));
        System.out.println(messageJadenWithOptional(null));
        System.out.println(messageJadenWithOptional(" "));

    }

    private static String messajeJaden(String phrase) {

        if(phrase == null || phrase.isEmpty())
            return null;

        return Arrays.stream(phrase.split("\\s"))
                .map(str -> Character.toUpperCase(str.charAt(0)) + str.substring(1))
                .collect(Collectors.joining(" "));
    }

    private static String messageJadenWithOptional(String phrase) {


        return Optional.ofNullable(phrase)
                .map(str -> str.trim().isEmpty()? null :
                        Arrays.stream(str.split("\\s"))
                                .map(e -> e.substring(0,1).toUpperCase()
                                        .concat(e.substring(1).toLowerCase()))
                                .collect(Collectors.joining(" ")) )
                .orElse(null);
    }

}
