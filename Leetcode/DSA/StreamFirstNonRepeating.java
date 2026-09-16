import java.util.*;

class Solution {

    // Using HashMap and Queue
    public String firstNonRepeating(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
            q.add(ch);
            
            while(!q.isEmpty()){
                if(map.get(q.peek()) > 1){ //Repeating ch
                    q.remove();
                }
                else{ //Non Repeating ch
                    sb.append(q.peek());
                    break;
                }
            }
            
            if(q.isEmpty())
                sb.append("#");
        }
        
        return sb.toString();
    }

    // Using LinkedHashSet and HashSet
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
