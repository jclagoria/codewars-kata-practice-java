package ar.com.problems.files;

public record WordCount(String word, int count) implements  Comparable<WordCount> {

    @Override
    public int compareTo(WordCount o) {
        var cmp = Integer.compare(o.count, count);

        if (cmp == 0) {
            cmp = this.word.compareTo(o.word);
        }

        return cmp;
    }
}
