package ar.com.problems.string;

import java.util.HashMap;

public class NumericalsOfAString {

    public static String numericals(String s) {
        HashMap<Character, Integer> charCounting = new HashMap<>();
        StringBuilder stBuilder = new StringBuilder();

        for (char characterCount: s.toCharArray()) {
            int count = charCounting.getOrDefault(characterCount, 0);
            charCounting.put(characterCount, count + 1);
            stBuilder.append(count + 1);
        }

        return stBuilder.toString();
    }

    public static String numericalsWithChanges(String s) {
        HashMap<Character, Integer> charCounting = new HashMap<>();
        StringBuilder stBuilder = new StringBuilder(s.length());

        for (char characterItem: s.toCharArray()) {
            int count = charCounting.compute(characterItem,
                    (key, value) -> value == null ? 1 : value + 1);
            stBuilder.append(count);
        }

        return stBuilder.toString();
    }
}
