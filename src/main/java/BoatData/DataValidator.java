package BoatData;

import org.apache.http.conn.util.InetAddressUtils;

import java.net.URL;

/**
 * Simple Validator class, that check for valid user input, when initializing software.
 */
public class DataValidator {

    /**
     * Boat security code validator method as 0.1-a1.
     * - Code must be 40 characters.
     * - Code can't contain any spaces.
     * - Code must have latin alphabet with numbers only.
     * Returns a boolean value.
     *
     * @param securityCode String that will be validated.
     * @return True if code is valid, false otherwise.
     */
    public static boolean validSecurityCode(final String securityCode) {
        if (securityCode.length() != 40) return false;
        else return !securityCode.contains(" ");
    }

    /**
     * Boat number validator method as 0.1-a1.
     * - Number must be 4 digits, starting with 1000.
     * Returns a boolean value.
     * @param boatNr String that will be validated.
     * @return True if number is valid, false otherwise.
     */
    public static boolean validBoatNumber(final String boatNr) {
        if (boatNr.length() != 4) return false;
        else if (boatNr.charAt(0) == '0') return false;
        else return boatNr.replaceAll("[0-9]", "").length() == 0;
    }

    /**
     * API address validator method as 0.1-a1.
     * Returns a boolean value.
     * @param apiAddress String that will be validated.
     * @return True if URL is valid, false otherwise.
     */
    public static boolean validAPI(final String apiAddress) {
        try {
            new URL(apiAddress).toURI();
            return true;
        }

        catch (Exception e) {
            return false;
        }
    }
}
