package ar.com.problems.numbers;

import java.util.stream.IntStream;

/**
 * There was a test in your class and you passed it. Congratulations!
 * But you're an ambitious person. You want to know if you're better than the average student in your class.
 * You receive an array with your peers' test scores. Now calculate the average and compare your score!
 * Return true if you're better, else false!
 * Note:
 * Your points are not included in the array of your class's points. Do not forget them when calculating the average score!
 */
public class HowGoodAreYouReally {
    public static boolean betterThanAverage(int[] classPoints, int yourPoints) {
        int sumPoints = 0;

        for(int sumClassPoint : classPoints) {
            sumPoints += sumClassPoint;
        }

        return ((sumPoints + yourPoints) / (classPoints.length + 1)) < yourPoints;
    }

    public static boolean betterThanAverageStream(int[] classPoints, int yourPoints) {
        return yourPoints >
                (IntStream.of(classPoints).sum() + yourPoints) / (classPoints.length + 1);
    }

    public static boolean betterThanAverageStreamV2(int[] classPoints, int yourPoints) {
        return yourPoints > IntStream
                .concat(
                        IntStream.of(classPoints),
                        IntStream.of(yourPoints)).average().orElse(0);
    }
}
