package ar.com.problems.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlphabetWarAirstrikeTest {

    @Test
    public void SampleTestCases() {
        assertEquals("Right side wins!", AlphabetWarAirstrike.alphabetWar("z"));
        assertEquals("Let's fight again!", AlphabetWarAirstrike.alphabetWar("****"));
        assertEquals("Let's fight again!", AlphabetWarAirstrike.alphabetWar("z*dq*mw*pb*s"));
        assertEquals("Let's fight again!", AlphabetWarAirstrike.alphabetWar("zdqmwpbs"));
        assertEquals("Right side wins!", AlphabetWarAirstrike.alphabetWar("zz*zzs"));
        assertEquals("Left side wins!", AlphabetWarAirstrike.alphabetWar("sz**z**zs"));
        assertEquals("Left side wins!", AlphabetWarAirstrike.alphabetWar("z*z*z*zs"));
        assertEquals("Left side wins!", AlphabetWarAirstrike.alphabetWar("*wwwwww*z*"));
    }

}