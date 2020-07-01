package BoatData;

public class BoatData {
    private String securityCode;
    private int boatNr;

    public BoatData(String securityCode, int boatNr) {
        this.securityCode = securityCode;
        this.boatNr = boatNr;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public int getBoatNr() {
        return boatNr;
    }

    public void setBoatNr(int boatNr) {
        this.boatNr = boatNr;
    }
}
