package ar.com.files;

import java.time.LocalDateTime;

public class LogLevelAndTimeFilter implements LogFilter {

    private final String level;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    public LogLevelAndTimeFilter(String level, LocalDateTime startTime, LocalDateTime endTime) {
        this.level = level;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean filter(LogEntry entry) {
        return entry.getLevel().equals(level)
                && !entry.getTimestamp().isBefore(startTime)
                && !entry.getTimestamp().isAfter(endTime);
    }
}
