import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> heap = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );

        for (char key : map.keySet()) {
            heap.add(key);
        }

        StringBuilder sb = new StringBuilder();
        while(!heap.isEmpty()){
            char ch = heap.poll();
            int count = map.get(ch);
            while(count > 0){
                sb.append(ch);
                count--;
            }
        }

        return sb.reverse().toString();
    }
}
