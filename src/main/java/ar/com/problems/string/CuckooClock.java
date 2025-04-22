package ar.com.problems.string;

/**
 * The cuckoo bird pops out of the cuckoo clock and chimes once on the quarter hour, half hour,
 * and three-quarter hour. At the beginning of each hour (1-12), it chimes out the hour.
 * Given the current time and a number n, determine the time when the cuckoo bird has chimed n  times.
 *
 * Input Parameters:
 * initial_time - a string in the format "HH:MM", where 1 ≤ HH ≤ 12 and 0 ≤ MM ≤ 59, with leading 0’s if necessary.
 * n - an integer representing the target number of chimes, with 1 <= n <= 200.
 *
 * Return Value: The time when the cuckoo bird has chimed n  times - a string in the same format as initial_time.
 *
 * If the cuckoo bird chimes at initial_time, include those chimes in the count.
 * If the nth chime is reached on the hour, report the time at the start of that hour
 * (i.e. assume the cuckoo finishes chiming before the minute is up).
 *
 * Example: "03:38", 19   should return "06:00".
 * Explanation: It chimes once at "03:45", 4 times at "04:00", once each at "04:15", "04:30", "04:45",
 * 5 times at "05:00", and once each at "05:15", "05:30", "05:45". At this point it has chimed 16 times,
 * so the 19th chime occurs when it chimes 6 times at "06:00".
 */
public class CuckooClock {

    /**
     * Calculate the time when the cuckoo bird has chimed n times.
     * <p>
     * The input time is rounded up to the next quarter hour.
     * Then, the time is incremented by quarter hours until the cuckoo bird has chimed n times.
     * The time when the cuckoo bird has chimed n times is returned.
     * <p>
     * If the cuckoo bird chimes at the input time, those chimes are included in the count.
     * If the nth chime is reached on the hour, the time at the start of that hour is returned.
     * <p>
     * Example: "03:38", 19 should return "06:00".
     * Explanation: It chimes once at "03:45", 4 times at "04:00", once each at "04:15", "04:30", "04:45",
     * 5 times at "05:00", and once each at "05:15", "05:30", "05:45". At this point it has chimed 16 times,
     * so the 19th chime occurs when it chimes 6 times at "06:00".
     *
     * @param inputTime the current time in the format "HH:MM", where 1 ≤ HH ≤ 12 and 0 ≤ MM ≤ 59, with leading 0’s if necessary
     * @param chimes the target number of chimes, with 1 <= n <= 200
     * @return the time when the cuckoo bird has chimed n times - a string in the same format as inputTime
     */
    public static String cuckooClock(String inputTime, int chimes) {
        int[] time = parseTime(inputTime);
        int hour = time[0];
        int minute = time[1];

        // Round up to the next quarter hour
        int[] roundedTime = roundToNextQuarterHour(hour, minute);
        hour = roundedTime[0];
        minute = roundedTime[1];

        int totalChimes = 0;

        while (totalChimes < chimes) {
            int chimesNow = getChimeCountAt(hour, minute);

            if(totalChimes + chimesNow >= chimes) {
                // The cuckoo bird has chimed n times
                return formatTime(hour, minute);
            }

            totalChimes += chimesNow;

            // Increment the time by one quarter hour
            int[] nextTime = incrementQuarterHour(hour, minute);
            hour = nextTime[0];
            minute = nextTime[1];
        }

        // This should never happen
        throw new IllegalStateException("Chime count exceeded without reaching target.");
    }

    /**
     * Parse the input time and return it as an array of two integers.
     * The first element is the hour and the second element is the minute.
     * The input time is assumed to be in the format "HH:MM", where 1 &le; HH &le; 12 and 0 &le; MM &le; 59.
     * Leading 0's are required if necessary.
     * @param time the current time in the format "HH:MM"
     * @return an array of two integers, the first is the hour and the second is the minute
     */
    private static int[] parseTime(String time) {
        String[] parts = time.split(":");
        return new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])};
    }

    /**
     * Round up the time to the next quarter hour.
     * If the minute is not already a multiple of 15 (i.e. 0, 15, 30 or 45),
     * increment the time by the necessary amount to reach the next quarter hour.
     * If this results in the minute being 60, increment the hour and reset the minute to 0.
     * @param hour the current hour (1-12)
     * @param minute the current minute (0-59)
     * @return an array containing the hour and minute of the rounded time
     */
    private static int[] roundToNextQuarterHour(int hour, int minute) {
        int remainder = minute % 15;
        if (remainder == 0)
            // If the minute is already a multiple of 15, return the current time
            return new int[] {hour, minute};

        // Increment the minute by the amount necessary to reach the next quarter hour
        minute += (15 - remainder);
        if (minute == 60) {
            // If the minute is now 60, increment the hour and reset the minute to 0
            minute = 0;
            hour = nextHour(hour);
        }

        return new int[]{hour, minute};
    }

    /**
     * Increment the time by a quarter hour.
     * <p>
     * If the minute is 45, incrementing by 15 minutes will result in 60 minutes.
     * In this case, the hour is incremented and the minute is reset to 0.
     * @param hour the current hour (1-12)
     * @param minute the current minute (0-59)
     * @return an array containing the next hour and minute
     */
    private static int[] incrementQuarterHour(int hour, int minute) {
        // Increment the minute by a quarter hour
        minute += 15;

        // If the minute is 60, increment the hour and reset the minute to 0
        if (minute == 60) {
            minute = 0;
            hour = nextHour(hour);
        }

        // Return the new hour and minute as an array
        return new int[] {hour, minute};
    }

    /**
     * Determines the next hour when the hour increments past 12.
     * Example: 12 -> 1, 1 -> 2, 2 -> 3, etc.
     * @param hour the current hour (1-12)
     * @return the next hour (1-12)
     */
    private static int nextHour(int hour) {
        return (hour % 12) + 1;
    }

    /**
     * Determines the number of chimes at a given hour and minute.
     *
     * @param hour the hour (1-12)
     * @param minute the minute (0, 15, 30, or 45)
     * @return the number of chimes: hour count on the hour, 1 on the quarter hours, 0 otherwise
     */
    private static int getChimeCountAt(int hour, int minute) {
        // Return the number of chimes based on the minute
        return switch (minute) {
            case 0 -> hour; // Chime the hour count at the start of a new hour
            case 15, 30, 45 -> 1; // Chime once at each quarter hour
            default -> 0; // No chime at other times
        };
    }

    /**
     * Returns a string representing the given hour and minute in the format "HH:MM".
     * HH is a zero-padded two-digit hour (1-12) and MM is a zero-padded two-digit minute (0-59).
     *
     * @param hour the hour (1-12)
     * @param minute the minute (0-59)
     * @return a string in the format "HH:MM"
     */
    private static String formatTime(int hour, int minute) {
        return String.format("%02d:%02d", hour, minute);
    }

}
