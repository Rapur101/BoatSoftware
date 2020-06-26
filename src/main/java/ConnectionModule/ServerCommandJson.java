package ConnectionModule;

public class ServerCommandJson {
    private String securityCode;
    private String commandTime;
    private String commandValue;

    public ServerCommandJson(String securityCode, String commandTime, String commandValue) {
        this.securityCode = securityCode;
        this.commandTime = commandTime;
        this.commandValue = commandValue;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public String getCommandTime() {
        return commandTime;
    }

    public String getCommandValue() {
        return commandValue;
    }
}
