public class DataSanitizer {
    public static void main(String[] args) {
        String[] rawAges = {"25", "thirty", " 42 ", "19", "", "N/A"};
        
        int totalAge = 0;

        System.out.println("--- Starting Data Sanitization ---");

        for (String raw : rawAges) {
            try {
                if (raw == null) throw new NumberFormatException(); //Check for null
                String cleanString = raw.trim(); //Remove whitespaces

                int age = Integer.parseInt(cleanString); //Convert String to Int

                totalAge += age; //Total
                System.out.println("Success: Added " + age);

            } catch (NumberFormatException e) {
                System.out.println("Warning: Skipped invalid entry -> \"" + raw + "\""); //Warning
            }
        }
        
        System.out.println("----------------------------------");
        System.out.println("Final Total Age: " + totalAge);
    }
}