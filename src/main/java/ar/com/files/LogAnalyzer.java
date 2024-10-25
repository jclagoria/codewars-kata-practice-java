package ar.com.files;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class LogAnalyzer {

    private final List<String> logFilterPaths;
    private final LogFilter filer;
    private final int threadCount;

    public LogAnalyzer(List<String> logFilterPaths, LogFilter filer, int threadCount) {
        this.logFilterPaths = logFilterPaths;
        this.filer = filer;
        this.threadCount = threadCount;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        String path = "/home/jlagoria/mount/secundary/dev/proyects/personal-site/generate-log-files";

        List<String> logFiles = Arrays.asList(path + "/server1.log", path + "/server2.log"); // Example log files

        // Create a filter for ERROR logs between specific timestamps
        LogFilter filter = new LogLevelAndTimeFilter("ERROR",
                LocalDateTime.of(2024, 10, 14, 12, 30),
                LocalDateTime.of(2024, 10, 16, 13, 00));

        // Instantiate LogAnalyzer with 4 threads
        LogAnalyzer analyzer = new LogAnalyzer(logFiles, filter, 4);

        // Analyze logs and print the filtered results
        List<LogEntry> filteredLogs = analyzer.analyzeLogs();
        filteredLogs.forEach(System.out::println); // Print results
    }

    public List<LogEntry> analyzeLogs() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        List<Future<List<LogEntry>>> futures = new ArrayList<>();

        for(String logFilePath : logFilterPaths) {
            Callable<List<LogEntry>> task = new LogParserTask(logFilePath, filer);
            futures.add(executor.submit(task));
        }

        List<LogEntry> result = new ArrayList<>();

        for(Future<List<LogEntry>> future : futures) {
            result.addAll(future.get());
        }

        executor.shutdown();
        return result;
    }

}
