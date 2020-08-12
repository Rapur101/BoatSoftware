import picocli.CommandLine;

/**
 * Main starting class.
 */
public class BoatyFloatMain {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";

    /**
     * Main method. Software cannot start without arguments.
     *
     * @param args 1 - Boat number
     *             2 - Security Code
     *             3 - API address
     *             4 - Debug mode (optional)
     *             5 - SIM PIN1 (optional)
     */
    public static void main(String[] args) {
        System.out.println(ANSI_CYAN + "|" + "-".repeat(17) + "|");
        System.out.println("|" + " ".repeat(17) + "|");
        System.out.println("|" + "  Boaty v0.1-a1  " + "|");
        System.out.println("|" + " ".repeat(17) + "|");
        System.out.println("|" + "-".repeat(17) + "|" + ANSI_RESET + "");
        System.out.println();


        System.exit(new CommandLine(new BoatyRunner()).execute(args));


    }
}
