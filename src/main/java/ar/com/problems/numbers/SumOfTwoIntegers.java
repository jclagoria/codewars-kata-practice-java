package ar.com.problems.numbers;

/**
 * Task
 * Given Two integers a , b , find The sum of them , BUT You are not allowed to use the operators + and -
 *
 * Notes
 * The numbers (a,b) may be positive , negative values or zeros .
 *
 * Returning value will be an integer .
 *
 * Java: the following methods are prohibited: addExact, average, collect, decrement, increment, nextAfter,
 * nextDown, nextUp, reduce, subtractExact, sum, summing .
 * The following classes are prohibited: BigDecimal and BigInteger .
 *
 * Input >> Output Examples
 * 1- Add (5,19) ==> return (24)
 *
 * 2- Add (-27,18) ==> return (-9)
 *
 * 3- Add (-14,-16) ==> return (-30)
 */
public class SumOfTwoIntegers {

    public static int add(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    public static int addRecursive(int a, int b) {
        if ( b == 0 ) return a;

        return addRecursive(a ^ b, (a & b) << 1);
    }

}
