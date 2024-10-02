package ar.com.problems.string;

/**
 * Introduction
 * A grille cipher was a technique for encrypting a plaintext by writing it onto a sheet of paper through a
 * pierced sheet (of paper or cardboard or similar). The earliest known description is due to the polymath
 * Girolamo Cardano in 1550. His proposal was for a rectangular stencil allowing single letters, syllables,
 * or words to be written, then later read, through its various apertures. The written fragments of the
 * plaintext could be further disguised by filling the gaps between the fragments with anodyne words or
 * letters. This variant is also an example of steganography, as are many of the grille ciphers. Wikipedia Link
 *
 * Task
 * Write a function that accepts two inputs: message and code and returns hidden message decrypted from message using the code.
 * The code is a nonnegative integer and it decrypts in binary the message.
 *
 * grille("abcdef", 5)  => "df"
 *
 * message : abcdef
 * code    : 000101
 * ----------------
 * result  : df
 */
public class GrillIt {

    static String grille (String message, int code) {

        if(message.trim().isEmpty()) {
            return "";
        }

        // Convert the integer code to a binary string
        String binaryCode = Integer.toBinaryString(code);

        // Adjust the binary code length to match the message length if necessary
        if (binaryCode.length() > message.length()) {
            binaryCode = binaryCode.substring(binaryCode.length() - message.length());
        } else if (binaryCode.length() < message.length()) {
            int lengthDifference = message.length() - binaryCode.length();
            binaryCode = "0".repeat(lengthDifference) + binaryCode;
        }

        // StringBuilder to store the result
        StringBuilder result = new StringBuilder();

        // Loop through the binary code and construct the hidden message
        for (int i = 0; i < binaryCode.length(); i++) {
            if (binaryCode.charAt(i) == '1') {
                result.append(message.charAt(i));
            }
        }

        // Return the decrypted message
        return result.toString();

    }
}
