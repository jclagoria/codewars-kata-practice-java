package ar.com.problems.numbers;

public class NegativeNumber {

    public static void main(String[] args) {

        olfFashionWay(100);
        newWaytoValidateNegative(35);
        newWaytoValidateNegative(-75);

    }

    private static void olfFashionWay(final int value) {
        System.out.println(Integer.signum(value) <= 0 ? value : (value * -1));
    }

    private static void newWaytoValidateNegative(final int x) {
        System.out.println(-Math.abs(x));
    }

}
