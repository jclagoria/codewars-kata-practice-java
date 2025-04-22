package ar.com.problems.string;

/**
 * You're on your way to the market when you hear beautiful music coming from a nearby street performer.
 * The notes come together like you wouln't believe as the musician puts together patterns of tunes.
 * As you wonder what kind of algorithm you could use to shift octaves by 8 pitches or something silly like that,
 * it dawns on you that you have been watching the musician for some 10 odd minutes.
 * You ask, "how much do people normally tip for something like this?" The artist looks up.
 * "It's always gonna be about tree fiddy."
 *
 * It was then that you realize the musician was a 400 foot tall beast from the paleolithic era!
 * The Loch Ness Monster almost tricked you!
 *
 * There are only 2 guaranteed ways to tell if you are speaking to The Loch Ness Monster:
 * A) it is a 400 foot tall beast from the paleolithic era; B) it will ask you for tree fiddy.
 *
 * Since Nessie is a master of disguise, the only way accurately tell is to look for the phrase "tree fiddy".
 * Since you are tired of being grifted by this monster, the time has come to code a solution for
 * finding The Loch Ness Monster. Note that the phrase can also be written as "3.50" or "three fifty".
 * Your function should return true if you're talking with The Loch Ness Moster, false otherwise.
 */
public class AStrangeTripToTheMarket {

    /**
     * Returns true if the input text contains the target phrases that identify
     * the Loch Ness Monster, false otherwise.
     *
     * @param text the input text to search
     * @return true if the text identifies the Loch Ness Monster, false otherwise
     */
    public static boolean isLockNessMonster(String text){
        if (text == null) {
            return false; // null input, not the monster
        }

        // Convert the text to lowercase to make the search case-insensitive
        String lowerCaseText = text.toLowerCase();

        // Check if in the text contains the target phrases
        return lowerCaseText.contains("tree fiddy") ||
                lowerCaseText.contains("3.50") ||
                lowerCaseText.contains("three fifty");
    }

    public static boolean isLockNessMonsterMatches(String text){
        return text.matches(".*(tree fiddy|three fifty|3.50).*");
    }

}
