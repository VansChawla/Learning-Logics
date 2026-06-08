import java.util.HashMap;

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                int currentCount = map.get(num);
                map.put(num, currentCount + 1);
            } else {
                map.put(num, 1);
            }
        }

        int result = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                result = key;
            }
        }

        return result;
    }
}
