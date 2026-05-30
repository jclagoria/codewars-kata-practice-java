package ar.com.problems.array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PrintingArrayElementsWithCommaDelimiters {

    /**
     * Returns a string representation of the given array. Each element of the
     * array is converted to a string using the
     * {@link #elementToString(Object)} method and the elements are joined with
     * a comma and a space in between.
     *
     * @param array the array to convert to a string
     * @return a string representation of the array
     */
    public static String printArray(Object[] array) {
        if (array == null || array.length == 0) {
            return "";
        }
        return Arrays.stream(array)
                .map(PrintingArrayElementsWithCommaDelimiters
                        ::elementToString)
                .collect(Collectors.joining(","));
    }

    /**
     * Returns a string representation of the given object. If the object is an
     * array, it is converted to a string using the
     * {@link #arrayToString(Object[])} method. Otherwise, the object is
     * converted to a string by calling its {@link Object#toString()} method.
     *
     * @param elem the object to convert to a string
     * @return a string representation of the object
     */
    private static String elementToString(Object elem) {
        if (elem == null) {
            return "null";
        }

        if (elem instanceof Object[]) {
            // Arrays.deepToString() is used to convert the array to a string
            // instead of Arrays.toString() because it handles arrays of
            // primitive types and multi-dimensional arrays.
            return Arrays.deepToString((Object[]) elem);
        }

        // If the object is an array of primitive types, it must be converted to
        // a string using the Arrays.toString() method.
        if (elem instanceof int[])    return Arrays.toString((int[]) elem);
        if (elem instanceof long[])   return Arrays.toString((long[]) elem);
        if (elem instanceof double[]) return Arrays.toString((double[]) elem);
        if (elem instanceof float[])  return Arrays.toString((float[]) elem);
        if (elem instanceof boolean[]) return Arrays.toString((boolean[]) elem);
        if (elem instanceof char[])   return Arrays.toString((char[]) elem);
        if (elem instanceof byte[])   return Arrays.toString((byte[]) elem);
        if (elem instanceof short[])  return Arrays.toString((short[]) elem);

        // fallback for any other Object
        return elem.toString();
    }

}
