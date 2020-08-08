import BoatData.BoatData;
import BoatData.DataValidator;

/**
 * Main starting class.
 */
public class BoatyFloatMain {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";

    /**
     * Main method. Software cannot start without arguments.
     * @param args 1 - Boat number
     *             2 - Security Code
     *             3 - API address
     */
    public static void main(String[] args) {
        System.out.println(ANSI_CYAN + "|" + "-".repeat(17) + "|");
        System.out.println("|" + " ".repeat(17) + "|");
        System.out.println("|" + "  Boaty v0.1-a1  " + "|");
        System.out.println("|" + " ".repeat(17) + "|");
        System.out.println("|" + "-".repeat(17) + "|" + ANSI_RESET + "");

        try {
            if (args.length != 3) throw new IllegalArgumentException("All arguments must be set!");
            else if (!DataValidator.validBoatNumber(args[0]))
                throw new IllegalArgumentException("Boat number is not valid!");
            else if (!DataValidator.validSecurityCode(args[1]))
                throw new IllegalArgumentException("Security code is not valid!");
            else if (!DataValidator.validAPI(args[2]))
                throw new IllegalArgumentException("API address is not valid!");

            Runner runner = new Runner(new BoatData(Integer.parseInt(args[0]), args[1], args[2]));
            runner.bootUp();

        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.print(illegalArgumentException.getMessage());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }
}
