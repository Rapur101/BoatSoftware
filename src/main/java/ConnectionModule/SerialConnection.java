package ConnectionModule;


import com.pi4j.io.serial.Baud;
import com.pi4j.io.serial.Serial;
import com.pi4j.io.serial.SerialConfig;
import com.pi4j.io.serial.SerialFactory;

import java.io.IOException;

/**
 * SerialConnection class handles serial USB connection with GSM/GPRS/GNSS HAT module.
 */
public class SerialConnection {

    Serial serial;

    /**
     * Constructor opens serial connection and starts data receiver listener.
     *
     * @throws IOException Is thrown when serial configuration is not valid.
     */
    public SerialConnection() throws IOException {
        serial = SerialFactory.createInstance();

        //Listener prints out modem responses.
        serial.addListener(serialDataEvent -> {
            try {
                System.out.println(serialDataEvent.getAsciiString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        SerialConfig serialConfig = new SerialConfig();
        serialConfig.device(Serial.FIRST_USB_COM_PORT).baud(Baud._115200); // device /dev/ttyUSB0

        serial.open(serialConfig); //Opens serial connection.

    }

    /**
     * Closes serial connection, if its still alive.
     *
     * @throws IOException Is thrown when serial isn't initialized.
     */
    public void closeSerial() throws IOException {
        if (serial.isOpen())
            serial.close();
    }

    /**
     * Writes data/commands to modem via open serial connection.
     *
     * @param data Input information/command.
     * @throws IOException Is thrown when serial connection is closed.
     */
    public void write(String data) throws IOException {
        if (serial.isOpen()) {
            System.out.println(data);
            serial.write(data);
        }
    }
}
