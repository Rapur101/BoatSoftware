package BoatData;

/**
 * Data holder class.
 */
public class BoatData {
    private String securityCode;
    private String apiAddress;
    private int boatNr;

    public BoatData(int boatNr, String securityCode, String apiAddress) {
        this.securityCode = securityCode;
        this.boatNr = boatNr;
        this.apiAddress = apiAddress;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public int getBoatNr() {
        return boatNr;
    }

    public String getApiAddress() {
        return apiAddress;
    }
}
