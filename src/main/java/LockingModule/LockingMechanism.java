package LockingModule;

import com.pi4j.io.gpio.*;

public class LockingMechanism {

    private GpioController gpioController;
    private GpioPinDigitalOutput gpioPinDigitalOutput;

    public LockingMechanism() {
        gpioController = GpioFactory.getInstance();
        gpioPinDigitalOutput = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_01, "LockingPin", PinState.HIGH);
    }

    public void lock() {
        gpioPinDigitalOutput.high();

    }

    public void unLock() {
        gpioPinDigitalOutput.low();
    }
}
