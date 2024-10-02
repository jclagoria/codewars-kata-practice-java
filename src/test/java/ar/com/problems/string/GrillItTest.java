package ar.com.problems.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class GrillItTest extends BaseTest {

    @Test
    public void setGrillItTest() {
        testing("df", GrillIt.grille("abcdef", 5));
        testing("", GrillIt.grille("", 5 ));
        testing("d", GrillIt.grille("abcd",1 ));
        testing("b", GrillIt.grille("0abd", 2));
        testing("codewars", GrillIt.grille("tcddoadepwweasresd", 77098));
        testing("q", GrillIt.grille("pq", 367605));
    }


}