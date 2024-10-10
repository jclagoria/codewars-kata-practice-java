package ar.com.problems.array;

public class CountOfPositivesSumOfNegatives {

    public static int[] countPositivesSumNegatives(int[] input)
    {

        if(input == null || input.length == 0) {
            return new int[2];
        }

        int countPositives = 0;
        int sumNegatives = 0;

        for(int value : input){
            if(value > 0) {
                countPositives++;
            }
            if(value < 0) {
                sumNegatives = sumNegatives + Math.abs(value);
            }
        }
                                                                    
        return new int[] {countPositives, Math.negateExact(sumNegatives)};
    }

}
