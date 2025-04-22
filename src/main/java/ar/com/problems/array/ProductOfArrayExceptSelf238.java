package ar.com.problems.array;

public class ProductOfArrayExceptSelf238 {

    public static int[] productExceptSelf(int[] nums) {

        int lengthArrNum = nums.length;
        int[] result = new int[lengthArrNum];

        int prefixProduct = 1;
        for(int i = 0; i <lengthArrNum; i++) {
            result[i] = prefixProduct;
            prefixProduct *= nums[i];
        }

        int suffixProduct = 1;
        for (int i = lengthArrNum - 1; i >= 0; i-- ) {
            result[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return result;
    }

}
