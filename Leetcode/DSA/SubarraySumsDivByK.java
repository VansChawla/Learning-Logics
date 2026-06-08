import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivByK {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int count = 0;
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;

            int rem = ((currentSum % k) + k) % k;

            if (map.containsKey(rem)) {
                count += map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }
}
