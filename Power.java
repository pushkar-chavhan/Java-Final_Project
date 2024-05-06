class PowerCalculator {

    // Function to calculate power using Math.pow method
    public static double calculatePower(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    // Main method to test the function
    public static void main(String[] args) {
        double base = 2;
        double exponent = 3;
        double result = calculatePower(base, exponent);
        System.out.println(result);
    }
}

