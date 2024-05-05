class MatrixOperations {

    // Addition of two matrices
    public static double[][] add(double[][] matrix1, double[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for addition.");
        }
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    // Subtraction of two matrices
    public static double[][] subtract(double[][] matrix1, double[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for subtraction.");
        }
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    // Multiplication of two matrices
    public static double[][] multiply(double[][] matrix1, double[][] matrix2) {
        int m1Rows = matrix1.length;
        int m1Cols = matrix1[0].length;
        int m2Rows = matrix2.length;
        int m2Cols = matrix2[0].length;
        if (m1Cols != m2Rows) {
            throw new IllegalArgumentException("Number of columns in the first matrix must be equal to the number of rows in the second matrix for multiplication.");
        }
        double[][] result = new double[m1Rows][m2Cols];
        for (int i = 0; i < m1Rows; i++) {
            for (int j = 0; j < m2Cols; j++) {
                for (int k = 0; k < m1Cols; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    // Transpose of a matrix
    public static double[][] transpose(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] result = new double[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    // Determinant of a square matrix (recursive approach)
    public static double determinant(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows != cols) {
            throw new IllegalArgumentException("Matrix must be square for determinant calculation.");
        }
        if (rows == 1) {
            return matrix[0][0];
        }
        if (rows == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        double det = 0;
        for (int j = 0; j < cols; j++) {
            double[][] minor = new double[rows - 1][cols - 1];
            for (int k = 1; k < rows; k++) {
                for (int l = 0, m = 0; l < cols; l++) {
                    if (l != j) {
                        minor[k - 1][m++] = matrix[k][l];
                    }
                }
            }
            det += Math.pow(-1, j) * matrix[0][j] * determinant(minor);
        }
        return det;
    }

    // Inverse of a square matrix
    public static double[][] inverse(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows != cols) {
            throw new IllegalArgumentException("Matrix must be square for inverse calculation.");
        }
        double determinant = determinant(matrix);
        if (determinant == 0) {
            throw new IllegalArgumentException("Matrix is singular, cannot find inverse.");
        }
        double[][] adjoint = adjoint(matrix);
        double[][] inverse = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                inverse[i][j] = adjoint[i][j] / determinant;
            }
        }
        return inverse;
    }

    // Adjoint of a square matrix
    public static double[][] adjoint(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows != cols) {
            throw new IllegalArgumentException("Matrix must be square for adjoint calculation.");
        }
        double[][] adjoint = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double[][] minor = new double[rows - 1][cols - 1];
                for (int k = 0; k < rows; k++) {
                    for (int l = 0; l < cols; l++) {
                        if (k != i && l != j) {
                            int i1 = k < i ? k : k - 1;
                            int j1 = l < j ? l : l - 1;
                            minor[i1][j1] = matrix[k][l];
                        }
                    }
                }
                double minorDeterminant = determinant(minor);
                adjoint[i][j] = Math.pow(-1, i + j) * minorDeterminant;
            }
        }
        return transpose(adjoint);
    }

    public static void main(String[] args) {
        // Test matrix operations
        double[][] matrix1 = {{1, 2, 3}, {4, 5, 6}};
        double[][] matrix2 = {{7, 8, 9}, {10, 11, 12}};
        double[][] matrix3 = {{1, 2}, {3, 4}};
        
        System.out.println("Matrix 1:");
        printMatrix(matrix1);
        System.out.println("Matrix 2:");
        printMatrix(matrix2);
        
        System.out.println("Matrix addition:");
        printMatrix(add(matrix1, matrix2));
        
        System.out.println("Matrix subtraction:");
        printMatrix(subtract(matrix1, matrix2));
        
        System.out.println("Matrix multiplication:");
        printMatrix(multiply(matrix1, matrix3));
        
        System.out.println("Matrix determinant:");
        System.out.println(determinant(matrix3));
        
        System.out.println("Matrix inverse:");
        printMatrix(inverse(matrix3));
    }
    
    // Helper method to print matrix
    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

