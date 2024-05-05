class NumberSystemConverter {

    // Decimal to Binary conversion
    public static String decimalToBinary(int decimal) {
        return Integer.toBinaryString(decimal);
    }

    // Binary to Decimal conversion
    public static int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }

    // Decimal to Octal conversion
    public static String decimalToOctal(int decimal) {
        return Integer.toOctalString(decimal);
    }

    // Octal to Decimal conversion
    public static int octalToDecimal(String octal) {
        return Integer.parseInt(octal, 8);
    }

    // Decimal to Hexadecimal conversion
    public static String decimalToHexadecimal(int decimal) {
        return Integer.toHexString(decimal);
    }

    // Hexadecimal to Decimal conversion
    public static int hexadecimalToDecimal(String hexadecimal) {
        return Integer.parseInt(hexadecimal, 16);
    }

    public static void main(String[] args) {
        // Test number system conversions
        int decimalNumber = 123;
        String binaryNumber = "101101";
        String octalNumber = "755";
        String hexadecimalNumber = "7B";

        System.out.println("Decimal to Binary: " + decimalToBinary(decimalNumber));
        System.out.println("Binary to Decimal: " + binaryToDecimal(binaryNumber));
        System.out.println("Decimal to Octal: " + decimalToOctal(decimalNumber));
        System.out.println("Octal to Decimal: " + octalToDecimal(octalNumber));
        System.out.println("Decimal to Hexadecimal: " + decimalToHexadecimal(decimalNumber));
        System.out.println("Hexadecimal to Decimal: " + hexadecimalToDecimal(hexadecimalNumber));
    }
}

