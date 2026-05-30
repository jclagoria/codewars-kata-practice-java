package ar.com.problems.string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.testng.Assert.assertThrows;

class StatisticsForAnAthleticAssociationTest {

    @Test
    public void BasicTests() {
        assertThat(StatisticsForAnAthleticAssociation.stat("01|15|59, 1|47|16, 01|17|20, 1|32|34, 2|17|17"))
                .isEqualTo("Range: 01|01|18 Average: 01|38|05 Median: 01|32|34");
        assertThat(StatisticsForAnAthleticAssociation.stat("02|15|59, 2|47|16, 02|17|20, 2|32|34, 2|17|17, 2|22|00, 2|31|41"))
                .isEqualTo("Range: 00|31|17 Average: 02|26|18 Median: 02|22|00");

    }

    @Test
    void shouldReturnEmptyStringWhenInputIsEmpty() {

        assertThat(StatisticsForAnAthleticAssociation.stat(null)).isEmpty();
        assertThat(StatisticsForAnAthleticAssociation.stat(""))
                .isEmpty();
        assertThat(StatisticsForAnAthleticAssociation.stat("   "))
                .isEmpty();
    }

    @Test
    void shouldComputeStatisticsForExampleCase() {
        String input = "01|15|59, 1|47|6, 01|17|20, 1|32|34, 2|3|17";
        String expected =
                "Range: 00|47|18 Average: 01|35|15 Median: 01|32|34";
        assertThat(StatisticsForAnAthleticAssociation.stat(input))
                .isEqualTo(expected);
    }

    @Test
    void shouldHandleSingleEntry() {
        String input = "0|0|30";
        String expected =
                "Range: 00|00|00 Average: 00|00|30 Median: 00|00|30";
        assertThat(StatisticsForAnAthleticAssociation.stat(input))
                .isEqualTo(expected);
    }

    @Test
    void shouldHandleEvenNumberOfEntries() {
        String input = "0|1|0, 0|2|0, 0|3|0, 0|4|0";
        // times in seconds: [60, 120, 180, 240]
        String expected =
                "Range: 00|03|00 Average: 00|02|30 Median: 00|02|30";
        assertThat(StatisticsForAnAthleticAssociation.stat(input))
                .isEqualTo(expected);
    }

    @Test
    void shouldNotMatchIncorrectExpected() {
        String input = "0|0|10, 0|0|20";
        // Correct: Range: 00|00|10 Average: 00|00|15 Median: 00|00|15
        String wrongExpected = "Range: 00|00|09 Average: 00|00|14 Median: 00|00|14";
        assertThat(StatisticsForAnAthleticAssociation.stat(input))
                .isNotEqualTo(wrongExpected);
    }

    @Test
    void shouldThrowOnInvalidFormat() {
        assertThrows(
                IllegalArgumentException.class,
                () -> StatisticsForAnAthleticAssociation.stat("foo|bar|baz")
        );
    }

}