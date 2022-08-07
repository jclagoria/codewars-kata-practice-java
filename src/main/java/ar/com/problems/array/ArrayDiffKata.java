package ar.com.problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;

import static java.util.Arrays.stream;


/**
 * Your goal in this kata is to implement a difference function, which subtracts one list from another and returns the result.

It should remove all values from list a, which are present in list b keeping their order.

Kata.arrayDiff(new int[] {1, 2}, new int[] {1}) => new int[] {2}
If a value is present in b, all of its occurrences must be removed from the other:

Kata.arrayDiff(new int[] {1, 2, 2, 2, 3}, new int[] {2}) => new int[] {1, 3}
 */
public class ArrayDiffKata {

    public static void main(String[] args) {
        
        firstArrayDiff(new int[] {1, 2}, new int[] {1});        
        goodSolutionDiffArray(new int[] {1,2,2,2,2, 3}, new int[] {2});
        anotherGoodOptionsSolutionDiffArray(new int[] {1,2,3,4,5,67, 90, 120 }, new int[] {2, 5, 90});
    }


    private static void firstArrayDiff(int[] elemntsToFilter, int[] filterArray) {

        Set<Integer> keyFilter = new HashSet<>();

        for (Integer keyInteger : filterArray) {
            keyFilter.add(keyInteger);
        }

        List<Integer> filterObjectList = new ArrayList<>();

        for (int i : elemntsToFilter) {
            
            if(!keyFilter.contains(i)) {
                filterObjectList.add(i);
            }
        }

        filterObjectList.stream()
                            .mapToInt(Integer::intValue).toArray();
    }

    /**     
     * Filter array using removeAll.
     * 
     * @param elemntsToFilter
     * @param filterArray
     * @return
     */
    private static int[] goodSolutionDiffArray(int[] elemntsToFilter, int[] filterArray) {

        List<Integer> listObjectToFilter = Arrays.stream(elemntsToFilter)
                                                    .boxed().collect(Collectors.toList());
        List<Integer> listObjectkeyFilter = Arrays.stream(filterArray)
                                                    .boxed().collect(Collectors.toList());

        listObjectToFilter.removeAll(listObjectkeyFilter);

        return listObjectToFilter.stream().mapToInt(Integer::intValue).toArray();

    }

    /**
     * Filter elements of one array using ArrayUtils.removeAllOcurrences
     * This function is locate in org.apache.commons.lang3.ArrayUtils!
     * 
     * @param elemntsToFilter
     * @param filterArray
     * @return
     */
    private static int[] anotherGoodOptionsSolutionDiffArray(int[] elemntsToFilter, int[] filterArray) {

        for (int elementToFilter : filterArray) {
            elemntsToFilter = ArrayUtils
                                .removeAllOccurrences(elemntsToFilter, elementToFilter);
        }

        return elemntsToFilter;

    }

    /**
     * Filter elements of the first array with the reference fo the elements of
     * the second array, useing only stream
     * 
     * @param elemntsToFilter
     * @param filterArray
     * @return
     */
    private static int[] diffArraysSolutionUsingStreamsOnly(int[] elemntsToFilter, int[] filterArray) {

        return stream(elemntsToFilter)
                        .filter(
                            objectA -> stream(filterArray)
                                .noneMatch(objectB -> objectB == objectA))
                        .toArray();

    }
}