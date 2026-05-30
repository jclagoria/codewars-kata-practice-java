package ar.com.problems.string;

import java.math.BigInteger;

/**
 * Introduction
 * RSA is one of the first public-key cryptosystems and is widely used for secure data transmission.
 * The security of RSA system lies in the fact that so far there is no efficient algorithm to factor large numbers.
 *
 * One of the earliest descriptions of the RSA system appeared in Martin Gardner's column Mathematical
 * Games in the August 1977 issue of Scientific American. There the inventors of RSA, Rivest, Shamir and Adleman,
 * offered a reward of $100 to whomever found the solution of the following challenge.
 *
 * Let n = 114381625 7578888676 6923577997 6146612010 2182967212 4236256256 1842935706 9352457338 9783059712
 * 3563958705 0589890751 4759929002 6879543541 be the public modulus and let e = 9007 be the public exponent.
 * Find the plaintext English message which corresponds to the encrypted message c = 96869613 7546220614 7714092225
 * 4355882905 7599911245 7431987469 5120930816 2982251457 0835693147 6622883989 6280133919 9055182994 5157815154
 * where the original plaintext English message had been transformed into a decimal number m using the
 * transformation 'A' = 01, 'B' = 02, ..., 'Z' = 26 with 00 indicating a space between words. An application
 * of this transformation to a secret message, followed by an eth powering modulo n,
 * results in the encrypted message c = m^e mod n.
 *
 * The modulus n has 129 decimal digits and is the product of a 64-digit prime p and a 65-digit prime
 * q such that both p-1 and q-1 are relatively prime to e. The primes p and q were kept secret.
 * It is well known that the encrypted message can be decrypted by computing m = c^d mod n
 * where d satisfies de ≡ 1 (mod (p-1)(q-1)). Because of the condition on p and q,
 * finding d is straightforward if (p-1)(q-1) is known. But knowing (p-1)(q-1) is equivalent to knowing
 * the secret primes p and q. It follows that the encrypted message can be decrypted by factoring n.
 *
 * Ron Rivest (the R in RSA) thought it would take 40 quadrillion years for the prime numbers to be found.
 * He was wrong. It took 17 years.
 *
 * In 1994 the Dutch mathematician Arjen K. Lenstra, together with a team of hundreds,
 * in just 8 months managed to find the solution. To organise the work, Lenstra needed hundreds of collaborators
 * all over the world and involved thousands of computers, the whole enterprise being coordinated via the Internet.
 *
 * Exhaustive mathematical proof of the RSA cryptosystem can be found here.
 *
 * RSA cryptosystem glossary
 * c - ciphertext (encrypted) message
 * m - decrypted message
 * p, q - two distinct prime numbers
 * n - semiprime modulus (pq number)
 * e - public exponent
 * d - private exponent
 * (e, n) - public key
 * (d, n) - private key
 * Task
 * Your task is to decrypt an text mesage that was encrypted using the common RSA algorithm. Although
 * this kind problem is not solvable in general case (if you do not know the secret key), in this kata you will be
 * given some additional data, which would be impossible to obtain in real life.
 *
 * You will be provided with 4 positive integer numbers in a decimal string format:
 *
 * String c; // ciphertext message
 * String e; // public exponent
 * String n; // semiprime modulus
 * String p; // one of the prime factors of the modulus n
 * You have to find out a private exponent d, decrypt a plaintext message m and convert it to
 * a human readable ASCII text string.
 *
 * Encoding rules are as follows: ' '=00; 'A'=01; 'B'=02; ...; 'Z'=26.
 *
 * Plaintext message encoding example:
 *
 * 1. Human readable string:
 *    "HELLO WORD"
 * 2. Encoded plaintext:
 *    08-05-12-12-15-00-23-15-18-12-04
 *    H  E  L  L  O     W  O  R  L  D
 * 3. Integer number to encrypt:
 *    m = 805121215002315181204
 * All inputs will be valid. Secret text will be not null length with all letters in uppercase up to 384 characters long.
 *
 * Examples
 * c = "372"; e = "3"; n = "391"; p = "23" => "Z"
 *
 * c = "121330"; e = "257"; n = "576761"; p = "673" => "RSA"
 *
 * c = "60407535701324298645777196"; e = "65537"; n = "160719199861369881405873071"; p = "17394808553761" => "HELLO WORLD"
 */
public class RSADecryptionChallenge {

    /**
     * Decrypts a ciphertext message using the common RSA algorithm.
     *
     * @param c ciphertext message
     * @param e public exponent
     * @param n semiprime modulus
     * @param p one of the prime factors of the modulus n
     * @return decrypted plaintext message
     */
    public static String decryptRsaCipher(String c, String e, String n, String p) {

        // Convert the input strings to BigInteger objects
        BigInteger biC = new BigInteger(c);
        BigInteger biE = new BigInteger(e);
        BigInteger biN = new BigInteger(n);
        BigInteger biP = new BigInteger(p);

        // Calculate the value of q
        BigInteger bigQ = biN.divide(biP);

        // Calculate the value of phi
        BigInteger phi = biP.subtract(BigInteger.ONE)
                .multiply(bigQ.subtract(BigInteger.ONE));

        // Calculate the private exponent d
        BigInteger d = biE.modInverse(phi);

        // Calculate the decrypted message
        BigInteger m = biC.modPow(d, biN);

        // Convert the decrypted message to its ASCII representation
        String digits = m.toString();
        if (digits.length() % 2 != 0) {
            digits = "0" + digits;
        }

        StringBuilder plain = new StringBuilder(digits.length() / 2);
        for (int i = 0; i < digits.length(); i += 2) {
            int code = Integer.parseInt(digits.substring(i, i + 2));
            if (code == 0) {
                plain.append(' ');
            } else {
                plain.append((char) ('A' + code - 1));
            }
        }

        return plain.toString();
    }

}
