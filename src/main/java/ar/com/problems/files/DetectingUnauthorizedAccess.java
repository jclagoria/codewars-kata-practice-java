package ar.com.problems.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DetectingUnauthorizedAccess {

    public static String detectAccess(String fileUrl) {

        int validIntents = 0;
        int invalidIntents = 0;

        try {
            List<String> lines = readFileToList(fileUrl);
            for (String line : lines) {
                if(isValidAttempt(line)) {
                    validIntents++;
                } else {
                    invalidIntents++;
                }
            }

        } catch (IOException e) {
            System.err.println("An error ocurred while reading the file: " + e.getMessage());
        }


        return String.format("submit "+validIntents+"true"+invalidIntents+"false");

    }

    private static List<String> readFileToList(String filePath) throws IOException {
        return Files.readAllLines(Path.of(filePath));
    }

    private static boolean isValidAttempt(String attempt) {
        boolean hasDigit = false;
        boolean hasLetters = false;
        int lastDigit = -1;
        char lastLetter = '\0';

        for (char c : attempt.toCharArray()) {
            if (Character.isDigit(c)) {
                if(hasLetters) {
                    return false;
                }
                int iDigit = c - '0';
                if(iDigit < lastDigit) {
                    return false;
                }
                lastDigit = iDigit;
                hasDigit = true;
            } else if (Character.isLowerCase(c)) {
                if (c < lastLetter) {
                    return false;
                }
                lastLetter = c;
                hasLetters = true;
            } else {
                return false;
            }
        }
        return true;
    }

}
