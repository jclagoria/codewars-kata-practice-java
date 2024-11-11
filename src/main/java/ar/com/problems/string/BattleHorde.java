package ar.com.problems.string;

public class BattleHorde {

    public static String solution(String zombies, String humans) {

        int zombiesTotalPower = 0;
        int humansTotalPower = 0;

        for (int i = 0; i < zombies.length(); i++) {
            zombiesTotalPower += Character.getNumericValue(zombies.charAt(i));
            humansTotalPower += Character.getNumericValue(humans.charAt(i));
        }

        if (zombiesTotalPower == humansTotalPower) {
            return "x";
        }

        int resultOfTheBattle = Math.abs(zombiesTotalPower - humansTotalPower);

        return resultOfTheBattle +
                (zombiesTotalPower > humansTotalPower ? "z" : "h");
    }

}
