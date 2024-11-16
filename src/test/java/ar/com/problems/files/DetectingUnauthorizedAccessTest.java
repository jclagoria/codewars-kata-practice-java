package ar.com.problems.files;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class DetectingUnauthorizedAccessTest {

    @Test
    public void testREadFileToList() throws IOException {
        Path filePath = Paths.get("src", "test", "resources", "files", "log.txt");

        assertEquals("submit 299true198false",
                DetectingUnauthorizedAccess.detectAccess(filePath.toString()));

    }
}