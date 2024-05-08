package ar.com.problems.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrdersSummaryTest extends BaseTest {

    @Test
    public void balanceStatements() {
        String l = "ZNGA 1300 2.66 B, CLH15.NYM 50 56.32 B, OWW 1000 11.623 B, OGG 20 580.1 B";
        assertEquals("Buy: 29499 Sell: 0",
                OrdersSummary.balanceStatements(l));
    }

    @Test
    public void balanceStatementsWithErrors() {
        String l = "GOOG 90 160.45 B, JPMC 67 12.8 S, MYSPACE 24.0 210 B, CITI 50 450 B, CSCO 100 55.5 S";
        assertEquals("Buy: 29499 Sell: 0",
                OrdersSummary.balanceStatements(l));
    }
}