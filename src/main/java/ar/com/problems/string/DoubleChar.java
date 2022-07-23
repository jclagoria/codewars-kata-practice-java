package ar.com.problems.string;

public class DoubleChar {

    public static void main(String[] args) {
        oldSolutionDoubleChar("Hola mundo cruel");
        usingReplaceSolution("Esto funciona?");
        usingCodePointsSolution("No me lo creo");
    }

    private static void oldSolutionDoubleChar (String value) {

        char[] valueChar = value.toCharArray();

        StringBuilder resultString = new StringBuilder();

        for (char letter: valueChar
        ) {
            resultString.append(letter).append(letter);
        }

        System.out.println(resultString.toString());

    }

    private static void usingReplaceSolution(String value) {
        System.out.println(value.replaceAll(".", "$0$0"));
    }

    private static void usingCodePointsSolution(String value) {
        System.out.println(value.codePoints()
                .collect(StringBuilder::new,
                        (sb, c) -> sb.appendCodePoint(c).appendCodePoint(c),
                        StringBuilder::append)
                .toString());
    }


}
