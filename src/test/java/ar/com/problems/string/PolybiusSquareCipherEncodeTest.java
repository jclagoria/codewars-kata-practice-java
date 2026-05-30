package ar.com.problems.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolybiusSquareCipherEncodeTest {

    @Test
    public void basicTests() {
        assertEquals("1334141552114243",
                PolybiusSquareCipherEncode.polybius("CODEWARS"));
        assertEquals("3534315412244543 434145114215 132435231542",
                PolybiusSquareCipherEncode.polybius("POLYBIUS SQUARE CIPHER"));
    }

}