package ar.com.problems.numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class NumberOfPeopleInTheBusTest {

    ArrayList<int[]> firstBus = new ArrayList<>();
    ArrayList<int[]> secondBus = new ArrayList<>();

    @BeforeEach
    void init() {
        firstBus.add(new int[] {10,0});
        firstBus.add(new int[] {3,5});
        firstBus.add(new int[] {2,5});

        secondBus.add(new int[] {25,1});
        secondBus.add(new int[] {4,8});
        secondBus.add(new int[] {6,9});
        secondBus.add(new int[] {4,3});
    }

    @Test
    @DisplayName("Count Passengers")
    public void testCountPassengers() {
        assertEquals(5, NumberOfPeopleInTheBus.countPassengers(firstBus));
        assertEquals(18, NumberOfPeopleInTheBus.countPassengers(secondBus));
    }

    @Test
    @DisplayName("Count Passengers Stream")
    public void testCountPassengerStream() {
        assertEquals(5, NumberOfPeopleInTheBus.countPassengerStream(firstBus));
        assertEquals(18, NumberOfPeopleInTheBus.countPassengerStream(secondBus));
    }

    @Test
    @DisplayName("Benchmark")
    public void testCountPassengersBenchmark() {
        long startTimeLoop = System.nanoTime();
        assertEquals(18, NumberOfPeopleInTheBus.countPassengers(secondBus));
        long endTimeLoop = System.nanoTime();
        long durationLoop = (endTimeLoop - startTimeLoop) / 1_000_000;  // Convert to milliseconds
        System.out.println("Loop-based approach took - Loop: " + durationLoop + " ms");

        long startTimeStream = System.nanoTime();
        assertEquals(18, NumberOfPeopleInTheBus.countPassengerStream(secondBus));
        long endTimeStream = System.nanoTime();
        long durationStream = (endTimeStream - startTimeStream) / 1_000_000;  // Convert to milliseconds
        System.out.println("Stream-based approach took: " + durationStream + " ms");
    }

}