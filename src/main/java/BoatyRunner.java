import DataValidators.BoatNumberConverter;
import DataValidators.SecurityCodeConverter;
import DataValidators.SimPinConverter;
import picocli.CommandLine;

import java.net.URL;

/**
 * Main runner class.
 */
@CommandLine.Command(name = "Boaty", version = "Boaty v0.1-a1", mixinStandardHelpOptions = true,
        sortOptions = false, footer = "BoatyFloat(c) 2020")
public class BoatyRunner implements Runnable {

    @CommandLine.Option(names = {"-sec", "--securityCode"}, required = true,
            converter = SecurityCodeConverter.class, description = "Security code")
    private String securityCode;

    @CommandLine.Option(names = {"-api", "--apiAddress"}, required = true,
            paramLabel = "<URL>", description = "API address URL/IP")
    private URL apiAddress;

    @CommandLine.Option(names = {"-nr", "--boatNr"}, required = true,
            converter = BoatNumberConverter.class, description = "Boat number")
    private int boatNr;

    @CommandLine.Option(names = {"-pin", "--simPin"}, paramLabel = "<pin1>",
            converter = SimPinConverter.class, description = "SIM Card PIN1")
    private String simPIN;

    @CommandLine.Option(names = {"-debug", "--debugMode"}, description = "start in debug mode")
    private boolean debugMode;


    @Override
    public void run() {
        if (debugMode) startDebugMode();
        else bootUp();
    }

    private void startDebugMode() {
        System.out.println("Tere debuggeri maailm!");

    }

    private void bootUp() {
        System.out.println("Tere maailm!");

    }
}
