package EncyptionModule;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

/**
 * Encryption class contains only static encryption methods.
 */
public class Encryption {

    /**
     * toSHA256 is static method to convert regular string to SHA256 string.
     *
     * @param password String that will be encoded.
     * @return Encoded SHA256 string.
     * @throws NoSuchAlgorithmException This exception is thrown when a particular cryptographic algorithm is
     *                                  requested but is not available in the environment.
     */
    public static String toSHA256(String password) throws NoSuchAlgorithmException {
        byte[] bytes = MessageDigest.getInstance("SHA-256").digest(password.getBytes());
        return Hex.encodeHexString(bytes);
    }


    /**
     * viaPBKDF2 is static method to convert regular password string to encoded w salt SHA256 string.
     *
     * @param password String that will be encoded.
     * @return Encoded SHA256 string
     * @throws NoSuchAlgorithmException This exception is thrown when a particular cryptographic algorithm is
     *                                  requested but is not available in the environment.
     * @throws InvalidKeySpecException  This is the exception for invalid key specifications.
     */
    public static String viaPBKDF2(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        int iterationCount = 1_000_00;

        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[32];
        secureRandom.nextBytes(salt);

        int outputLengthBits = 256;

        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterationCount, outputLengthBits);
        byte[] key = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(spec).getEncoded();

        return Hex.encodeHexString(key);
    }

}
