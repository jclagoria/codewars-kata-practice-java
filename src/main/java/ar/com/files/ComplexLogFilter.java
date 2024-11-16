package ar.com.files;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ComplexLogFilter implements LogFilter {

    private final String level;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final List<String> keywords;

    public ComplexLogFilter(String level, LocalDateTime startTime,
                            LocalDateTime endTime, List<String> keywords) {
        this.level = level;
        this.startTime = startTime;
        this.endTime = endTime;
        this.keywords = keywords;
    }

    @Override
    public boolean filter(LogEntry entry) {

        boolean matchesLevel = level == null || entry.getLevel().equals(level);

        boolean matchesTimeRange = (startTime != null || !entry.getTimestamp().isBefore(startTime)) &&
                (endTime != null || !entry.getTimestamp().isAfter(endTime));

        boolean matchesKeywords = keywords.isEmpty()
                || keywords.stream().anyMatch(entry.getMessage()::contains);

        // Return true only if all conditions match
        return matchesLevel && matchesTimeRange && matchesKeywords;
    }

    // Main method for testing the new filtering criteria
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String path = "/home/jlagoria/mount/secundary/dev/proyects/personal-site/generate-log-files";

        List<String> logFiles = Arrays.asList(path + "/server1.log", path + "/server2.log"); // Example log fileses

        // Create a filter for ERROR logs between specific timestamps and containing keywords like "failed" or "error"
        LogFilter filter = new ComplexLogFilter("ERROR",
                LocalDateTime.of(2024, 10, 15, 12, 30),
                LocalDateTime.of(2024, 10, 15, 13, 00),
                Arrays.asList("failed", "connection"));

        // Instantiate LogAnalyzer with 4 threads
        LogAnalyzer analyzer = new LogAnalyzer(logFiles, filter, 4);

        // Analyze logs and print the filtered results
        List<LogEntry> filteredLogs = analyzer.analyzeLogs();
        filteredLogs.forEach(System.out::println); // Print results
    }
}
