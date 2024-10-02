package ar.com.problems.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumeralsEncoderTest extends BaseTest {

    RomanNumeralsEncoder encoder = new RomanNumeralsEncoder();
    @Test
    public void shouldConvertToRoman() {
        assertEquals("solution(1) should equal to I", "I", encoder.encodeNumber(1));
        assertEquals("solution(20) should equal to XX", "XX", encoder.encodeNumber(20));
        assertEquals("solution(445) should equal to CDXLV", "CDXLV", encoder.encodeNumber(445));
        assertEquals("solution(2551) should equal to MMDLI", "MMDLI", encoder.encodeNumber(2551));
    }

}