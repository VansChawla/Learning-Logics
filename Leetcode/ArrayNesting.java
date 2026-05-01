public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        int res = 0;
        boolean[] seen = new boolean[nums.length];
        for (int i : nums) {
            int cnt = 0;
            while (!seen[i]) {
                seen[i] = true;
                cnt++;
                i = nums[i];
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}
