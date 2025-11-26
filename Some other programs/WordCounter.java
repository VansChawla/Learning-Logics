import java.util.*;

public class WordCounter{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        
        System.out.print("Enter a line of text: ");
        String input = sc.nextLine().toLowerCase().replaceAll("[^a-zA-Z ]", "");

        String[] words = input.split("\\s+");

        for(String word : words){

            if (word.isEmpty()) {
                continue; 
            }

            if(map.containsKey(word)){
                int currentCount = map.get(word);
                map.put(word, currentCount + 1);
            } else
                map.put(word, 1);

        }

        System.out.println("\n--- Word Frequency Table ---");
        System.out.printf("%-15s %s\n", "Word", "Count"); // Header
        System.out.println("-------------------------");

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            // %-15s means "String, left-aligned, 15 spaces wide"
            // %d means "Integer"
            System.out.printf("%-15s %d\n", entry.getKey(), entry.getValue());
        }
    }
}