package ar.com.problems.booleans;

public class IsHeGonnaSurvive {

    public static boolean hero(int bullets, int dragons) {

        int numOfRounds = bullets / 2;

        if ( dragons > bullets || dragons > numOfRounds ) {
            return false;
        }

        return (dragons / numOfRounds) % numOfRounds >= 0;
    }

}
