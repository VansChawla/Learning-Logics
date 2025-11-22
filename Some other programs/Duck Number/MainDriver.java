// We need to import the class we made in the other folder
import NumberPackage.DuckNumber;
import java.util.Scanner;

public class MainDriver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number to check: ");
        int val = sc.nextInt();

        // Create an object of the child class
        DuckNumber dn = new DuckNumber(val);

        // Check logic using the method we wrote
        if (dn.isDuckNumber()) {
            System.out.println(val + " is a Duck Number.");
        } else {
            System.out.println(val + " is NOT a Duck Number.");
        }
    }
}