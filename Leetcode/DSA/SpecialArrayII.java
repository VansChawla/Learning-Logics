public class SpecialArrayII {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] groupId = new int[n];
        int currentGroup = 0;

        // Step 1: Assign group IDs
        // Elements in the same "special" sequence share the same ID
        for (int i = 1; i < n; i++) {
            if (nums[i] % 2 == nums[i - 1] % 2) {
                currentGroup++; // Parity match? Start a new group
            }
            groupId[i] = currentGroup;
        }

        // Step 2: Answer queries
        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            // If start and end are in the same group, the whole range is special
            result[i] = groupId[queries[i][0]] == groupId[queries[i][1]];
        }

        return result;
    }

}
