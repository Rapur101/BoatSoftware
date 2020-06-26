package EncyptionModule;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Encryption class contains only static encryption methods.
 */
public class Encryption {

    /**
     * toSHA256 is static method to convert regular string to SHA256 string.
     *
     * @param inputString String that will be encoded.
     * @return Encoded SHA256 string.
     * @throws NoSuchAlgorithmException This exception is thrown when a particular cryptographic algorithm is
     *                                  requested but is not available in the environment.
     */
    private static String toSHA256(String inputString) throws NoSuchAlgorithmException {
        byte[] bytes = MessageDigest.getInstance("SHA-256").digest(inputString.getBytes());
        return Hex.encodeHexString(bytes);
    }

}
