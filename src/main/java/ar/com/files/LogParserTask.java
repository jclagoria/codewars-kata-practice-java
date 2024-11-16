package ar.com.files;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class LogParserTask implements Callable<List<LogEntry>> {

    private final String logFilePath;
    private final LogFilter logFilter;

    public LogParserTask(String logFilePath, LogFilter logFilter) {
        this.logFilePath = logFilePath;
        this.logFilter = logFilter;
    }

    @Override
    public List<LogEntry> call() throws Exception {
        List<LogEntry> filteredLog = new ArrayList<LogEntry>();
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(logFilePath))) {
            String line;
            while( (line = reader.readLine()) != null ) {
                LogEntry entry = LogEntry.parse(line);
                if(entry != null && logFilter.filter(entry)) {
                    filteredLog.add(entry);
                }
            }
        }
        return filteredLog;
    }
}
