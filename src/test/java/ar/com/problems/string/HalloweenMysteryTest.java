package ar.com.problems.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HalloweenMysteryTest {

    @Test
    @DisplayName("Should return a string with the name of Killers")
    public void testFindTheKiller_ReturnStringNotEmpty() {
        assertEquals("Dracula", HalloweenMystery
                .findTheKiller("d~~~~~a",
                        List.of("Dracula", "Freddy Krueger", "Jason Voorhees", "Michael Myers")));
        assertEquals("Freddy,Freddier,Fredderic", HalloweenMystery
                .findTheKiller("~r~dd~",
                        List.of("Freddy", "Freddier", "Fredderic", "Michael Myers")));


    }

    @Test
    @DisplayName("Should return an empty string")
    public void testFindTheKiller_ReturnStringEmpty() {
        assertEquals("", HalloweenMystery
                .findTheKiller("~r~dd$",
                        List.of("Freddy", "Freddier", "Fredderic", "Michael Myers")));
        assertEquals("", HalloweenMystery
                .findTheKiller("mi~~def",
                        List.of("Midudev", "Midu", "Madeval")));

    }

}