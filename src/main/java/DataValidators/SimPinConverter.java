package DataValidators;

import picocli.CommandLine;

public class SimPinConverter implements CommandLine.ITypeConverter<String> {
    @Override
    public String convert(String s) {
        if (s.replaceAll("[0-9]", "").length() != 0)
            throw new CommandLine.TypeConversionException("PIN must be numeric!");

        if (s.length() != 4)
            throw new CommandLine.TypeConversionException("PIN 1 must be four numbers!");

        return s;
    }
}
