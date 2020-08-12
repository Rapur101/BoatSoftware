package DataValidators;

import picocli.CommandLine;

/**
 * Boat number validator class as 0.1-a1.
 * <p>
 * Makes sure, that input argument is numeric, contains 4 digits and isn't zero.
 */
public class BoatNumberConverter implements CommandLine.ITypeConverter<Integer> {

    @Override
    public Integer convert(String s) {
        if (s.replaceAll("[0-9]", "").length() != 0)
            throw new CommandLine.TypeConversionException("Boat number must be numeric!");

        if (s.length() != 4)
            throw new CommandLine.TypeConversionException("Boat number must contain four numbers!");

        if (s.charAt(0) == '0' || s.charAt(3) == '0')
            throw new CommandLine.TypeConversionException("Boat number can't start or end with 0!");

        return Integer.parseInt(s);
    }
}
