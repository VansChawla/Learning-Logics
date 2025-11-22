package NumberPackage;

public class DuckNumber extends Number {

    // Parameterized Constructor
    public DuckNumber(int n) {
        // "super" calls the constructor in Number.java
        super(n);
    }

    // Method to check if it is a Duck Number
    public boolean isDuckNumber() {
        // 1. A Duck number must be a positive number
        if (n <= 0) {
            return false;
        }

        // 2. Convert the number to a String to check for '0'
        String numStr = String.valueOf(n);

        // 3. Return true if it contains a zero
        if (numStr.contains("0")) {
            return true;
        } else {
            return false;
        }
    }
}