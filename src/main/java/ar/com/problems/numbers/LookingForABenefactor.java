package ar.com.problems.numbers;

import java.util.Arrays;

/**
 * The accounts of the "Fat to Fit Club (FFC)" association are supervised by John as a volunteered accountant.
 * The association is funded through financial donations from generous benefactors. John has a list
 * of the first n donations: [14, 30, 5, 7, 9, 11, 15] He wants to know how much the next benefactor
 * should give to the association so that the average of the first n + 1 donations should reach an average of 30.
 * After doing the math he found 149. He thinks that he could have made a mistake.
 *
 * Could you help him?
 *
 * Task
 * The function should return the expected donation (rounded up to the next integer)
 * that will permit to reach the average.
 *
 * Should the last donation be a non positive number (<= 0) John wants us either to throw an error or return
 * such value so he will clearly see that his expectations are not great enough.
 *
 * In "Sample Tests" you can see what to return.
 *
 * Notes:
 * all donations and new average are numbers (integers or floats), array of donations can be empty.
 * See examples below and "Sample Tests" to see which return is to be done.
 *
 * array: [14, 30, 5, 7, 9, 11, 15], new average: 92 -> result: 645
 * array: [14, 30, 5, 7, 9, 11, 15], new average: 2  -> result: variable, see "Sample Tests"
 *
 */
public class LookingForABenefactor {

    /**
     * The function should return the expected donation (rounded up to the next integer)
     * that will permit to reach the average.
     * <p>
     * Should the last donation be a non positive number (<= 0) John wants us either to throw an error or return
     * such value so he will clearly see that his expectations are not great enough.
     * </p>
     *
     * @param arr   an array of donations
     * @param navg  the target average
     * @return      the expected donation
     * @throws      IllegalArgumentException if the target average is not positive
     */
    public static long newAvg(double[] arr, double navg) {

        if (navg <= 0) {
            throw new IllegalArgumentException("Target average must be positive");
        }

        // current sum of donations
        double currentSum = Arrays.stream(arr).sum();
        // required sum to reach the target average
        double requiredSum = navg * (arr.length + 1);
        // next donation to reach the target average
        double nextDonation = requiredSum - currentSum;

        if (nextDonation <= 0) {
            throw new IllegalArgumentException("Expected donation must be positive");
        }

        // round up next donation to the next integer
        return (long) Math.ceil(nextDonation);
    }
}
