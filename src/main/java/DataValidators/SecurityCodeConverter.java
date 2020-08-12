package DataValidators;

import picocli.CommandLine;

public class SecurityCodeConverter implements CommandLine.ITypeConverter<String> {
    @Override
    public String convert(String s) {
        if (s.length() != 40)
            throw new CommandLine.TypeConversionException("Security code length must be 40 characters!");

        return s;
    }
}
