package ar.com.problems.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumericalsOfAStringTest {

    @Test
    @DisplayName("Should return 1112111121311 when a send Hello, World!")
    public void numericalOfAString_firstTest() {
        assertEquals("1112111121311", NumericalsOfAString.numericals("Hello, World!"));
    }

    @Test
    @DisplayName("Should return 11121111213112111131224132411122 when a send Hello, World! It's me, JuanKa!")
    public void numericalOfAString_secondTest() {
        assertEquals("111211112131121111312241111122", NumericalsOfAString.numericals("Hello, World! It's me, JuanKa!"));
    }
    @Test
    @DisplayName("Should return 11111111112111111111312211142215222312314635332712412824269353101211112237132823942 when a send Hello, Dumped for High-Rank Party, His Defective Death Skill made Him OP & She Regrets")
    public void numericalOfAString_thirdTest() {
        assertEquals("11111111112111111111312211142215222312314635332712412824269353101211112237132823942",
                NumericalsOfAString.numericals("Dumped for High-Rank Party, His Defective Death Skill made Him OP & She Regrets"));
    }

    @Test
    @DisplayName("Should return 1112111121311 when a send Hello, World!")
    public void numericalsWithChanges_firstTest() {
        assertEquals("1112111121311", NumericalsOfAString.numericalsWithChanges("Hello, World!"));
    }

    @Test
    @DisplayName("Should return 11121111213112111131224132411122 when a send Hello, World! It's me, JuanKa!")
    public void numericalsWithChanges_secondTest() {
        assertEquals("111211112131121111312241111122",
                NumericalsOfAString.numericalsWithChanges("Hello, World! It's me, JuanKa!"));
    }
    @Test
    @DisplayName("Should return 11111111112111111111312211142215222312314635332712412824269353101211112237132823942 when a send Hello, Dumped for High-Rank Party, His Defective Death Skill made Him OP & She Regrets")
    public void numericalsWithChanges_thirdTest() {
        assertEquals("11111111112111111111312211142215222312314635332712412824269353101211112237132823942",
                NumericalsOfAString
                        .numericalsWithChanges("Dumped for High-Rank Party, His Defective Death Skill made Him OP & She Regrets"));
    }
}