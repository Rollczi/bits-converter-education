import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BitsConverter {

    private static final Pattern PATTERN = Pattern.compile("^([01]+)\\.([01]+)$");

    public static double toDecimal(String input) {
        Matcher matcher = PATTERN.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid bits");
        }

        double sum = 0;
        double subDecimal = 0;

        String integerPart = matcher.group(1);
        String decimalPart = matcher.group(2);

        for (int i = 0; i < integerPart.length(); i++) {
            if (integerPart.charAt(i) == '1') {
                sum += Math.pow(2, integerPart.length() - i - 1);
            }
        }

        for (int i = 0; i < decimalPart.length(); i++) {
            if (decimalPart.charAt(i) == '1') {
                subDecimal += Math.pow(2, -(i + 1));
            }
        }

        return sum + subDecimal;
    }

    public static String toBinary(double number) {
        StringBuilder binary = new StringBuilder();

        int integer = (int) number;
        double decimal = number - integer;

        while (integer > 0) {
            binary.insert(0, integer % 2);
            integer /= 2;
        }

        binary.append(".");

        while (decimal > 0) {
            if (binary.length() > 32) {
                throw new IllegalArgumentException("Invalid bits");
            }

            decimal *= 2;
            if (decimal >= 1) {
                binary.append("1");
                decimal -= 1;
            } else {
                binary.append("0");
            }
        }

        return binary.toString();
    }

}
