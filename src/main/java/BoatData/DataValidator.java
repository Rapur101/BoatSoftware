package BoatData;

public class DataValidator {

    public static boolean validSecurityCode(String securityCode) {
        if (securityCode.length() != 40) return false;
        else if (securityCode.contains(" ")) return false;
        else return securityCode.replaceAll("[a-z][A-Z][0-9]", "").length() == 0;
    }

    public static boolean validBoatNumber(String boatNr) {
        if (boatNr.length() != 4) return false;
        else return boatNr.replaceAll("[0-9]", "").length() == 0;
    }
}
