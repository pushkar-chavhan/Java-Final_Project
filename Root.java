class RootCalculator {

    // Function to calculate nth root using Math.pow method
    public static double calculateNthRoot(double number, int n) {
        return Math.pow(number, 1.0 / n);
    }

    // Main method to test the function
    public static void main(String[] args) {
        double number = 36;
        int n = 2;
        double result = calculateNthRoot(number, n);
        System.out.println(result);
    }
}

