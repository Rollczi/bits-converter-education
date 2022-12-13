public class Main {

    public static void main(String[] args) {
        String bits = "101.1011";
        double decimal = BitsConverter.toDecimal(bits);
        String binary = BitsConverter.toBinary(decimal);

        System.out.println("Bits: " + bits);
        System.out.println("Decimal: " + decimal);
        System.out.println("Binary: " + binary);
    }

}