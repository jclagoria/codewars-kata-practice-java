package ar.com.problems.string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RSADecryptionChallengeTest {

    @Test
    public void testExamplesFromDescription() {
        assertEquals("Z", RSADecryptionChallenge
                .decryptRsaCipher("372", "3", "391", "23"));
        assertEquals("RSA", RSADecryptionChallenge
                .decryptRsaCipher("121330", "257", "576761", "673"));
        assertEquals("HELLO WORLD", RSADecryptionChallenge
                .decryptRsaCipher("60407535701324298645777196", "65537", "160719199861369881405873071", "17394808553761"));
    }

    @Test
    void decryptSingleLetter() {
        String c = "372";
        String e = "3";
        String n = "391";
        String p = "23";
        String result = RSADecryptionChallenge.decryptRsaCipher(c, e, n, p);
        assertThat(result).isEqualTo("Z");
    }

    @Test
    void decryptShortWord() {
        String c = "121330";
        String e = "257";
        String n = "576761";
        String p = "673";
        String result = RSADecryptionChallenge.decryptRsaCipher(c, e, n, p);
        assertThat(result).isEqualTo("RSA");
    }

    @Test
    void decryptHelloWorld() {
        String c = "60407535701324298645777196";
        String e = "65537";
        String n = "160719199861369881405873071";
        String p = "17394808553761";
        String result = RSADecryptionChallenge.decryptRsaCipher(c, e, n, p);
        assertThat(result).isEqualTo("HELLO WORLD");
    }
  
}