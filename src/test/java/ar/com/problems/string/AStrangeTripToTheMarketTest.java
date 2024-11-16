package ar.com.problems.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AStrangeTripToTheMarketTest {

    @Test
    @DisplayName("Return --> True -->  I Found Nessie")
    public void testBasicTrue() {
        String n = "Your girlscout cookies are ready to ship. Your total comes to tree fiddy";
        assertTrue(AStrangeTripToTheMarket.isLockNessMonster(n));
    }
    @Test
    @DisplayName("Return --> False -->  Not Found Nessie")
    public void testBasicFalse() {
        String n = "Yo, I heard you were on the lookout for Nessie. Let me know if you need assistance.";
        assertFalse(AStrangeTripToTheMarket.isLockNessMonster(n));
    }

    @Test
    @DisplayName("Return --> True -->  I Found Nessie")
    public void testMatchesTrue() {
        String n = "Your girlscout cookies are ready to ship. Your total comes to tree fiddy";
        assertTrue(AStrangeTripToTheMarket.isLockNessMonsterMatches(n));
    }
    @Test
    @DisplayName("Return --> False -->  Not Found Nessie")
    public void testMatchesFalse() {
        String n = "Yo, I heard you were on the lookout for Nessie. Let me know if you need assistance.";
        assertFalse(AStrangeTripToTheMarket.isLockNessMonsterMatches(n));
    }

}