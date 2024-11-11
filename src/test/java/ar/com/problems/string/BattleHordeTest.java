package ar.com.problems.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleHordeTest {

    @Test
    @DisplayName("Should Return a Draw between Zombies and Humans")
    public void battleHordeTest_DrawSuccess() {
        assertEquals("x", BattleHorde.solution("123", "321"));
        assertEquals("x", BattleHorde.solution("987", "789"));
    }

    @Test
    @DisplayName("Should return a Win for the Humans Hordes")
    public void battleHordeTest_HumansWon() {
        assertEquals("2h", BattleHorde.solution("242", "334"));
        assertEquals("3h", BattleHorde.solution("555", "666"));
    }

    @Test
    @DisplayName("Should return a Win for the Zombies Hordes")
    public void battleHordeTest_ZombiesWon() {
        assertEquals("3z", BattleHorde.solution("4598", "7682"));
        assertEquals("8z", BattleHorde.solution("918", "352"));
    }

}