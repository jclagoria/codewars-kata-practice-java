package ar.com.test;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
class ProcessFilesTest {

    @Test
    public void testFunction() {

        Map<String, Integer> value = ProcessFiles.analyzeFileInResources("text.md");

        assertTrue(value.isEmpty());

    }

  
}