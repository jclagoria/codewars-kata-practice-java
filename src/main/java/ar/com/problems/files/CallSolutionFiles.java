package ar.com.problems.files;

public final class CallSolutionFiles {

    public static void main(String[] args) {
        var result = StopWordCounter.countStopWords("files/text.md");
        result.forEach(System.out::println);
    }

}
