public class Runner {

    public static void main(String[] args) {
        if (args.length < 3) System.out.println("All arguments must be set!");
        else if (BoatData.validBoatNumber(args[0]) && BoatData.validSecurityCode(args[0])) {
            final BoatData boatData = new BoatData(args[0], Integer.parseInt(args[1]));
        }

    }
}
