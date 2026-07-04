import java.util.ArrayList;
import java.util.List;

class CountAndSay {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        
        String current = "1";
        
        for (int i = 1; i < n; i++) {
            List<int[]> pairs = stringToPairs(current);
            current = pairsToString(pairs);
        }
        
        return current;
    }

    private List<int[]> stringToPairs(String s) {
        List<int[]> pairs = new ArrayList<>();
        int len = s.length();
        int i = 0;
        
        while (i < len) {
            char currentDigit = s.charAt(i);
            int count = 0;
            
            while (i < len && s.charAt(i) == currentDigit) {
                count++;
                i++;
            }
            
            int digitValue = currentDigit - '0';
            pairs.add(new int[]{digitValue, count});
        }
        
        return pairs;
    }

    private String pairsToString(List<int[]> pairs) {
        StringBuilder sb = new StringBuilder();
        
        for (int[] pair : pairs) {
            int digit = pair[0];
            int frequency = pair[1];
            
            sb.append(frequency).append(digit);
        }
        
        return sb.toString();
    }
}
