import java.util.Scanner;

// 1. The Matrix Class (Logic)
class Matrix {
    // Data Members
    int[][] data;
    int rows;
    int cols;

    // Default Constructor (Allocates 2x2)
    public Matrix() {
        this.rows = 2;
        this.cols = 2;
        this.data = new int[2][2];
    }

    // Parameterized Constructor (Allocates custom size)
    public Matrix(int r, int c) {
        this.rows = r;
        this.cols = c;
        this.data = new int[r][c];
    }

    // Method to capture input
    public void initialize() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements for a " + rows + "x" + cols + " matrix:");
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter element [" + i + "][" + j + "]: ");
                data[i][j] = sc.nextInt();
            }
        }
    }

    // Method to add two matrices
    public Matrix doAddition(Matrix other) {
        // Validation: Check if dimensions match
        if (this.rows != other.rows || this.cols != other.cols) {
            System.out.println("Matrices Unequal: Addition Failed");
            return null; // Return null to indicate failure
        }

        // Create a NEW matrix to store the result
        Matrix sumMatrix = new Matrix(this.rows, this.cols);

        // Loop through and add elements
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                // Current object's data + Passed object's data
                sumMatrix.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }

        return sumMatrix; // Return the new object
    }

    // Method to display the matrix
    public void show() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(data[i][j] + "\t"); // \t gives a tab space
            }
            System.out.println(); // Move to next line after printing one row
        }
    }
}

// 2. The Driver Class (Main Program)
public class MatrixDriver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Matrix 1 Creation ---");
        System.out.print("Enter rows for Matrix 1: ");
        int r1 = sc.nextInt();
        System.out.print("Enter cols for Matrix 1: ");
        int c1 = sc.nextInt();
        
        Matrix m1 = new Matrix(r1, c1);
        m1.initialize();

        System.out.println("\n--- Matrix 2 Creation ---");
        System.out.print("Enter rows for Matrix 2: ");
        int r2 = sc.nextInt();
        System.out.print("Enter cols for Matrix 2: ");
        int c2 = sc.nextInt();

        Matrix m2 = new Matrix(r2, c2);
        m2.initialize();

        System.out.println("\n--- Calculating Sum ---");
        Matrix result = m1.doAddition(m2);

        if (result != null) {
            System.out.println("The Resultant Matrix is:");
            result.show();
        }
    }
}