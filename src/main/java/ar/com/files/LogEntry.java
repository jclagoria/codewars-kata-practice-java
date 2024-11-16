package ar.com.files;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogEntry {

    private final LocalDateTime timestamp;
    private final String level;
    private final String message;

    private static final DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("yyyy-MM-dd HH:mm:ss");

    public LogEntry(LocalDateTime timestamp, String level, String message) {
        this.timestamp = timestamp;
        this.level = level;
        this.message = message;
    }

    public static LogEntry parse(String line) {
        Pattern logPattern = Pattern.compile("^(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}),(INFO|WARN|ERROR),(.*)$");
        Matcher matcher = logPattern.matcher(line);
        if (matcher.matches()) {
            LocalDateTime timestamp = LocalDateTime.parse(matcher.group(1), formatter);
            String level = matcher.group(2);
            String message = matcher.group(3);
            return new LogEntry(timestamp, level, message);
        }

        return null;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return timestamp.format(formatter) + "," + level + "," + message;
    }
}
