package LockingModule;

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

/**
 * DockingController detects voltage input changes in GPIO_02 (Pin 13).
 */
public class DockingController {
    private GpioController gpioController;
    private GpioPinDigitalInput gpioPinDigitalInput;
    private boolean docked;

    public DockingController() {
        gpioController = GpioFactory.getInstance();
        gpioPinDigitalInput = gpioController.provisionDigitalInputPin(RaspiPin.GPIO_02, PinPullResistance.PULL_DOWN);
        gpioPinDigitalInput.addListener((GpioPinListenerDigital) gpioPinDigitalStateChangeEvent -> docked = gpioPinDigitalStateChangeEvent.getState() == PinState.HIGH);
    }

    /**
     * @return True if pin is under loading voltage. False otherwise.
     */
    public boolean isDocked() {
        return docked;
    }
}
