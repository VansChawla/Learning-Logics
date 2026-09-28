class CircularArrayLoop {
    public int calcNextIdx(int [] nums, int curr) {
        int next = curr;
        int seq = nums[curr];

        if (seq > 0) {
            // [2, -1, -1, 2, 2]
            // 0.  1.  2. 3. 4 5
            next = (next + seq) % nums.length;
        } else {
            // mod with negatives
            // java
            // 8
            // 4
            // 0 1 2 3 4 5 6 7
            // -5
            // move forward 3 steps
            // -5 + 8 = 3
            // len of the nums
            // move curr by 3 steps
            // -10 % 8 -> -2
            //
            int mod = seq % nums.length;
            int forward = nums.length + mod;
            next = (curr + forward) % nums.length;
        }

        return next;
    }
    public boolean circularArrayLoop(int[] nums) {
        // seq, k > 1, all positives or all negatives
        // check for all indexes
        for (int i = 0; i < nums.length; i = i + 1) {
            // set -> inexes that we have visited so far
            // flag -> isPos = nums[i] > 0
            if (nums[i] == 0) {
                continue;
            }
            boolean isPos = nums[i] > 0;

            int slow = i;
            int fast = i;

            do{
                slow = calcNextIdx(nums, slow);

                fast = calcNextIdx(nums, fast);
                if (isPos) {
                    if (nums[fast] < 0) {
                        break;
                    }
                } else {
                    if (nums[fast] > 0) {
                        break;
                    }
                }

                fast = calcNextIdx(nums, fast);
                if (isPos) {
                    if (nums[fast] < 0) {
                        break;
                    }
                } else {
                    if (nums[fast] > 0) {
                        break;
                    }
                }

                if (slow == fast) {
                    // cycle
                    // k > 1
                    if (slow != calcNextIdx(nums, slow)) {
                        return true;
                    }
                    break;
                }
            } while (slow != fast);

            int curr = i;
            if (isPos) {
                while (nums[curr] > 0) {
                    int next = calcNextIdx(nums, curr);
                    nums[curr] = 0;
                    curr = next;
                }
            } else {
                while (nums[curr] < 0) {
                    int next = calcNextIdx(nums, curr);
                    nums[curr] = 0;
                    curr = next;
                }
            }
        }

        return false;
    }
}