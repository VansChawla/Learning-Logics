class SlidingSubarrayBeauty {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int r = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }

            if (i >= k - 1) {
                result[r++] = getXthSmallest(map, x);

                int outElement = nums[i - k + 1];
                if (outElement < 0) {
                    if (map.get(outElement) == 1) {
                        map.remove(outElement);
                    } else {
                        map.put(outElement, map.get(outElement) - 1);
                    }
                }
            }
        }
        return result;
    }

    private int getXthSmallest(TreeMap<Integer, Integer> map, int x) {
        int count = 0;
        
        for (int key : map.keySet()) {
            count += map.get(key);
            if (count >= x) {
                return key; 
            }
        }
        return 0;
    }
}
