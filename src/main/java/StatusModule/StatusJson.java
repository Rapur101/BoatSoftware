package StatusModule;

import java.io.Serializable;
import java.time.LocalDateTime;

public class StatusJson implements Serializable {

    private int boatNr;
    private String securityCode;
    private String logTime;
    private String location;
    private String codeNr;
    private String otherInfo;

    public StatusJson(int boatNr, String securityCode, String location, String codeNr, String otherInfo) {
        this.boatNr = boatNr;
        this.securityCode = securityCode;
        this.logTime = LocalDateTime.now().toString();
        this.location = location;
        this.codeNr = codeNr;
        this.otherInfo = otherInfo;
    }
}
