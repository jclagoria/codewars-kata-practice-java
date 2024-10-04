package ar.com.problems.array;

public class ConvertNumberToReversedArrayOfDigits {

    public static int[] digitize(long n) {

        char[] numberChr = String.valueOf(n).toCharArray();
        int indexChar = numberChr.length;
        int[] digits = new int[indexChar];
        int index = 0;

        for (int i = (indexChar - 1); i >= 0; i--) {
            digits[index] = Character.getNumericValue(numberChr[i]);
            index++;
        }

        return digits;
    }

    public static int[] digitizeIntStream(long n) {
        return new StringBuilder().append(n)
                .reverse().chars()
                .map(Character::getNumericValue)
                .toArray();
    }

}
