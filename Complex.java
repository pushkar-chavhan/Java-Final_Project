class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    // Addition of two complex numbers
    public static ComplexNumber add(ComplexNumber c1, ComplexNumber c2) {
        double real = c1.getReal() + c2.getReal();
        double imaginary = c1.getImaginary() + c2.getImaginary();
        return new ComplexNumber(real, imaginary);
    }

    // Subtraction of two complex numbers
    public static ComplexNumber subtract(ComplexNumber c1, ComplexNumber c2) {
        double real = c1.getReal() - c2.getReal();
        double imaginary = c1.getImaginary() - c2.getImaginary();
        return new ComplexNumber(real, imaginary);
    }

    // Multiplication of two complex numbers
    public static ComplexNumber multiply(ComplexNumber c1, ComplexNumber c2) {
        double real = c1.getReal() * c2.getReal() - c1.getImaginary() * c2.getImaginary();
        double imaginary = c1.getReal() * c2.getImaginary() + c1.getImaginary() * c2.getReal();
        return new ComplexNumber(real, imaginary);
    }

    // Division of two complex numbers
    public static ComplexNumber divide(ComplexNumber c1, ComplexNumber c2) {
        double denominator = c2.getReal() * c2.getReal() + c2.getImaginary() * c2.getImaginary();
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero!");
        }
        double real = (c1.getReal() * c2.getReal() + c1.getImaginary() * c2.getImaginary()) / denominator;
        double imaginary = (c1.getImaginary() * c2.getReal() - c1.getReal() * c2.getImaginary()) / denominator;
        return new ComplexNumber(real, imaginary);
    }

    // Absolute value of a complex number
    public double abs() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    // Argument (angle) of a complex number
    public double arg() {
        return Math.atan2(imaginary, real);
    }

    // Conjugate of a complex number
    public ComplexNumber conjugate() {
        return new ComplexNumber(real, -imaginary);
    }

    // String representation of a complex number
    public String toString() {
        if (imaginary >= 0) {
            return real + " + " + imaginary + "i";
        } else {
            return real + " - " + (-imaginary) + "i";
        }
    }

    public static void main(String[] args) {
        // Test complex number operations
        ComplexNumber c1 = new ComplexNumber(3, 4);
        ComplexNumber c2 = new ComplexNumber(1, -2);

        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);

        System.out.println("Addition: " + add(c1, c2));
        System.out.println("Subtraction: " + subtract(c1, c2));
        System.out.println("Multiplication: " + multiply(c1, c2));
        System.out.println("Division: " + divide(c1, c2));

        System.out.println("Absolute value of c1: " + c1.abs());
        System.out.println("Argument of c2: " + c2.arg());
        System.out.println("Conjugate of c1: " + c1.conjugate());
    }
}

