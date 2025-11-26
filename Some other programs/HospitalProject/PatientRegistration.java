import HospitalSystem.InvalidBloodGroupException;
import java.util.Scanner;
import java.util.Arrays;

public class PatientRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- ABC Hospitals Patient Registration ---");

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Address: ");
        String address = sc.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        boolean isValid = false;

        String[] validGroups = {"A+VE", "A-VE", "B+VE", "B-VE", "O+VE", "O-VE", "AB+VE", "AB-VE"};

        while(!isValid){
            try{
                System.out.print("Enter Blood Group (e.g., A+VE, O-VE): ");
                String inputGroup = sc.nextLine().toUpperCase();

                boolean found = Arrays.asList(validGroups).contains(inputGroup);

                if(!found){

                    throw new InvalidBloodGroupException("You have entered wrong blood group. Enter valid data");
                }

                isValid = true;

                System.out.print("Willing to donate blood? (y/n): ");
                char choice = sc.next().charAt(0);

                if (choice == 'y' || choice == 'Y') {
                    System.out.println("Registered as Blood Donor. Thank you");
                } else {
                    System.out.println("Thank You");
                }

            } catch (InvalidBloodGroupException e) {
                
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
