package ar.com.problems.string;

import java.util.*;

/**
 * The input will be an array of dictionaries.
 *
 * Return the values as a string-seperated sentence in the order of their keys' integer equivalent (increasing order).
 *
 * The keys are not reoccurring and their range is -999 < key < 999. The dictionaries'
 * keys & values will always be strings and will always not be empty.
 *
 * Example
 * Input:
 * List = [
 *         {'4': 'dog' }, {'2': 'took'}, {'3': 'his'},
 *         {'-2': 'Vatsan'}, {'5': 'for'}, {'6': 'a'}, {'12': 'spin'}
 *        ]
 *
 * Output:
 * 'Vatsan took his dog for a spin'
 */
public class StringReordering {

    public static String buildSequence(List<String[]> arrayOfObjects) {

        TreeMap<Integer, String> mapOfStrings = new TreeMap<>();

        for(String[] elements : arrayOfObjects) {
            int keyElement = Integer.parseInt(elements[0]);
            String valueElement = elements[1];
            mapOfStrings.put(keyElement, valueElement);
        }

        return String.join(" ", mapOfStrings.values());
    }

    public static String buildSequenceList(List<String[]> arrayOfObjects) {
        String[] valuesArray = new String[1999];

        for(String[] elements : arrayOfObjects) {
            int key = Integer.parseInt(elements[0]);
            String value = elements[1];

            valuesArray[key + 999] = value;
        }

        List<String> arrayOfStrings = Arrays.stream(valuesArray).filter(Objects::nonNull).toList();

        return String.join(" ", arrayOfStrings);
    }
}
