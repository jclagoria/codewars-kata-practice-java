package ar.com.problems.numbers;

import ar.com.problems.string.BaseTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class WriteNumberExpandedFormTest extends BaseTest {

    @Test
    public void testExpandedForm() {
        assertEquals("10 + 2", WriteNumberExpandedForm.expandedForm(12));
        assertEquals("40 + 2", WriteNumberExpandedForm.expandedForm(42));
        assertEquals("70000 + 300 + 4", WriteNumberExpandedForm.expandedForm(70304));
    }

    @Test
    public void testExpandedFormIntStream() {
        assertEquals("10 + 2", WriteNumberExpandedForm.expandedFormIntStream(12));
        assertEquals("40 + 2", WriteNumberExpandedForm.expandedFormIntStream(42));
        assertEquals("70000 + 300 + 4", WriteNumberExpandedForm.expandedFormIntStream(70304));
    }

    @Test
    public void testExpandedFormAWayEasy() {
        assertEquals("20 + 3", WriteNumberExpandedForm.expandedFormAWayEasy(23));
        assertEquals("400 + 50 + 2", WriteNumberExpandedForm.expandedFormAWayEasy(452));
        assertEquals("80000 + 300 + 4", WriteNumberExpandedForm.expandedFormAWayEasy(80304));
    }

}