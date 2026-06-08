import java.util.*;

class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
            // if(map.containsKey(num)){
            //     int currentCount = map.get(num);
            //     map.put(num, currentCount+1);
            // } else {
            //     map.put(num, 1);
            // }
        }

        int result[] = new int[2];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result[idx++] = entry.getKey();
            }
        }

        return result;
    }
}