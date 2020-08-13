package GPIOControllerModule;

import com.pi4j.io.gpio.*;

/**
 * GPIO controller class handles all pins.
 * Locking pins work with opposite states:
 *      HIGH - unlocked
 *      LOW - locked
 */
public class HardwareAccess {

    private final GpioController gpioController;

    private final GpioPinDigitalInput dockingPin;
    private final GpioPinDigitalOutput lockingPin;

    private final GpioPinDigitalOutput gsmModemPin;


    /**
     * Constructor. Initializes GPIO controller and required locking, docking and modem controller pins.
     */
    public HardwareAccess() {
        //Create GPIO controller.
        gpioController = GpioFactory.getInstance();

        //Provision gpio pins #01 (in), #02 (out), #07 (in).
        dockingPin = gpioController.provisionDigitalInputPin(RaspiPin.GPIO_02, "dockingPin", PinPullResistance.PULL_DOWN);
        lockingPin = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_01, "lockingPin", PinState.HIGH);
        gsmModemPin = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_07, "gsmModemPin", PinState.LOW);

        //Setting shutdown options, if application suddenly terminates. Better safe than sorry. =)
        lockingPin.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        gsmModemPin.setShutdownOptions(true,PinState.LOW);
    }

    /**
     * @return If boat is at dock and charging aka properly locked.
     */
    public boolean isDocked() {
        return dockingPin.isHigh();
    }

    public void lock() {
        lockingPin.low();
    }

    public void unLock() {
        lockingPin.high();
    }

    /**
     * Sets gpio pin #07 high state for 4 sec. This will power on GSM/GPRS/GNSS HAT.
     * Acts as PWR KEY.
     */
    public void bootupModem() {
        gsmModemPin.pulse(4000); //Time in millis.
    }

    public void shutdownAll() {
        gpioController.shutdown();
    }
}
