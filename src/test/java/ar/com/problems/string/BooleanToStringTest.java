package ar.com.problems.string;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

public class BooleanToStringTest extends BaseTest {

    @Test
    @DisplayName("Expected true")
    public void convertTestTrue() {
        assertEquals("true", BooleanToString.convert(true));
    }

    @Test
    @DisplayName("Expected false")
    public void convertTestFalse() {
        assertEquals("false", BooleanToString.convert(false));
    }


}