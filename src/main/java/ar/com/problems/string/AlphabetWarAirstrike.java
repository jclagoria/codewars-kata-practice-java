package ar.com.problems.string;

/**
 * Introduction
 * There is a war...between alphabets!
 * There are two groups of hostile letters. The tension between left side letters and right side
 * letters was too high and the war began. The letters called airstrike to help them in war - dashes and dots
 * are spread throughout the battlefield. Who will win?
 *
 * Task
 * Write a function that accepts a fight string which consists of only small letters and * which
 * represents a bomb drop place. Return who wins the fight after bombs are exploded. When the left side
 * wins return Left side wins!, and when the right side wins return Right side wins!.
 * In other cases, return Let's fight again!.
 *
 * The left side letters and their power:
 *
 *  w - 4
 *  p - 3
 *  b - 2
 *  s - 1
 * The right side letters and their power:
 *
 *  m - 4
 *  q - 3
 *  d - 2
 *  z - 1
 * The other letters don't have power and are only victims.
 * The * bombs kill the adjacent letters ( i.e. aa*aa => a___a, **aa** => ______ );
 *
 * Example
 * AlphabetWar("s*zz");           //=> Right side wins!
 * AlphabetWar("*zd*qm*wp*bs*"); //=> Let's fight again!
 * AlphabetWar("zzzz*s*");       //=> Right side wins!
 * AlphabetWar("www*www****z");  //=> Left side wins!
 */
public class AlphabetWarAirstrike {

    public static String alphabetWar(String fight) {

        // Define the power of the left and right side letters
        int[] leftPower = new int[26];
        int[] rightPower = new int[26];

        leftPower['w' - 'a'] = 4;
        leftPower['p' - 'a'] = 3;
        leftPower['b' - 'a'] = 2;
        leftPower['s' - 'a'] = 1;

        rightPower['m' - 'a'] = 4;
        rightPower['q' - 'a'] = 3;
        rightPower['d' - 'a'] = 2;
        rightPower['z' - 'a'] = 1;

        // Create a copy of the battlefield to calculate bomb effects
        char[] battlefield = fight.toCharArray();
        boolean[] destroyed = new boolean[battlefield.length];

        // Mark destroyed regions
        for (int i = 0; i < battlefield.length; i++) {
            if (battlefield[i] == '*') {
                destroyed[i] = true; // Mark the bomb itself
                if (i > 0) destroyed[i - 1] = true; // Mark left neighbor
                if (i < battlefield.length - 1) destroyed[i + 1] = true; // Mark right neighbor
            }
        }

        // Calculate the total power for both sides
        int leftScore = 0, rightScore = 0;
        for (int i = 0; i < battlefield.length; i++) {
            if (!destroyed[i] && battlefield[i] >= 'a' && battlefield[i] <= 'z') {
                leftScore += leftPower[battlefield[i] - 'a'];
                rightScore += rightPower[battlefield[i] - 'a'];
            }
        }

        // Determine the result
        if (leftScore > rightScore) {
            return "Left side wins!";
        } else if (rightScore > leftScore) {
            return "Right side wins!";
        } else {
            return "Let's fight again!";
        }
    }
}
