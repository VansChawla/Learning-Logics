import java.util.Scanner;

public class StringCompression {
    public static void main(String[] args) {
        String input = "aaaabbbbcccccddddeeee";
        StringBuilder result = new StringBuilder();
        
        int count = 1;
        for (int i = 0; i < input.length(); i++) {
            // If it is the last char or next char is different
            if (i == input.length() - 1 || input.charAt(i) != input.charAt(i + 1)) {
                result.append(input.charAt(i));
                result.append(count);
                count = 1; // Reset count
            } else {
                count++;
            }
        }
        
        System.out.println("Compressed: " + result);
    }
}