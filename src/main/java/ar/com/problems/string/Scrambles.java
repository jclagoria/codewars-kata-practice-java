package ar.com.problems.string;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * Complete the function scramble(str1, str2) that returns true if a portion of str1 characters can be rearranged to match str2, otherwise returns false.
 *
 * Notes:
 *
 * Only lower case letters will be used (a-z). No punctuation or digits will be included.
 * Performance needs to be considered.
 * Examples
 * scramble('rkqodlw', 'world') ==> True
 * scramble('cedewaraaossoqqyt', 'codewars') ==> True
 * scramble('katas', 'steak') ==> False
 *
 */
public class Scrambles {
    public static void main(String[] args) {

        System.out.println(scramble("katas", "steak"));
        System.out.println(scrambleAnotherSolution("rkqodlw", "world"));
        System.out.println(scrambleCompreTwoMaps("cedewaraaossoqqyt", "codewars"));

    }

    private static boolean scramble(String str1, String str2) {

        // Create frequency maps for both strings
        Map<Character, Integer> freqMap1 = buildFrequencyMap(str1);
        Map<Character, Integer> freqMap2 = buildFrequencyMap(str2);

        // Check if str1 can be rearranged to match str2
        for (Map.Entry<Character, Integer> entry : freqMap2.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();

            // If str1 doesn't have enough occurrences of a character, return false
            if (!freqMap1.containsKey(ch) || freqMap1.get(ch) < count) {
                return false;
            }
        }

        return true;
    }

    private static Map<Character, Integer> buildFrequencyMap(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char ch : str.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        return freqMap;
    }


    private static boolean scrambleAnotherSolution(String str1, String str2) {
        Map<Integer, Integer> cnt = new HashMap<>();
        str2.chars().forEach(i -> cnt.put(i, cnt.getOrDefault(i, 0) + 1));
        str1.chars().filter(i -> cnt.containsKey(i)).forEach(i -> cnt.put(i, cnt.get(i) - 1));
        return cnt.values().stream().filter(i -> i>0).count() == 0;
    }

    private static boolean scrambleCompreTwoMaps(String str1, String str2) {
        Map<String, Long> str1Map = Stream.of(str1.split("")).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        Map<String, Long> str2Map = Stream.of(str2.split("")).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        return str2Map.entrySet().stream().allMatch(e -> str1Map.get(e.getKey()) != null && e.getValue() <= str1Map.get(e.getKey()));
    }

}
