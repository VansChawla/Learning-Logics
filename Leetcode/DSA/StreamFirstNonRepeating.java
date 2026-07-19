import java.util.*;

class Solution {
    public String firstNonRepeating(String s) {
        StringBuilder sb = new StringBuilder();
        
        // Tracks characters seen exactly once
        Set<Character> uniqueSet = new LinkedHashSet<>(); 
        // Tracks characters seen more than once
        Set<Character> repeatedSet = new HashSet<>(); 

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!repeatedSet.contains(ch)) {
                if (uniqueSet.contains(ch)) {
                    // Character is repeating now: move it from unique to repeated
                    uniqueSet.remove(ch);
                    repeatedSet.add(ch);
                } else {
                    // First time seeing this character
                    uniqueSet.add(ch);
                }
            }

            if (uniqueSet.isEmpty()) {
                sb.append("#");
            } else {
                // Get the very first item in the LinkedHashSet
                sb.append(uniqueSet.iterator().next());
            }
        }

        return sb.toString();
    }
}
