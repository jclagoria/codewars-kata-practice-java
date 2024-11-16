package ar.com.problems.string;

public class ReverseWordsString {

    public static String reverseWords(String s) {

        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }

        return sb.toString().trim();
    }

    public static String reverseWordsBestOption(String s) {
        StringBuilder result = new StringBuilder();
        int end = s.length() - 1;

        while (end >= 0) {
            while (end >= 0 && s.charAt(end) == ' ') {
                end--;
            }

            if (end < 0) {
                break;
            }

            int start = end;
            while (start >= 0 && s.charAt(start) != ' ') {
                start--;
            }

            result.append(s, start + 1, end + 1).append(" ");

            end = start -1;
        }

        if (!result.isEmpty()) {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }

}
