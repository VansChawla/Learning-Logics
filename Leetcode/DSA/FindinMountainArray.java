public class FindinMountainArray {
    /**
     * // This is MountainArray's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface MountainArray {
     * public int get(int index);
     * public int length();
     * }
     */

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        // Step 1: Find the index of the peak element
        int peakIndex = findPeak(mountainArr, n);

        // Step 2: Binary Search on the ascending left slope
        // We search from index 0 up to the peakIndex
        int leftResult = binarySearchAscending(mountainArr, target, 0, peakIndex);
        if (leftResult != -1) {
            return leftResult; // Found it on the left! This is guaranteed to be the min index.
        }

        // Step 3: Binary Search on the descending right slope
        // We search from peakIndex + 1 up to the end of the array
        return binarySearchDescending(mountainArr, target, peakIndex + 1, n - 1);
    }

    // --- Helper 1: Find Peak ---
    private int findPeak(MountainArray arr, int n) {
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            // If mid is smaller than the next element, we are on the ascending slope
            if (arr.get(mid) < arr.get(mid + 1)) {
                left = mid + 1; // The peak must be further right
            } else {
                // We are on the descending slope (or at the peak), so the peak is to the left
                // (or is mid)
                right = mid;
            }
        }
        // At the end of the loop, left == right, pointing exactly to the peak
        return left;
    }

    // --- Helper 2: Standard Binary Search (Ascending) ---
    private int binarySearchAscending(MountainArray arr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = arr.get(mid);

            if (midVal == target)
                return mid;
            else if (midVal < target)
                left = mid + 1; // Target is larger, move right
            else
                right = mid - 1; // Target is smaller, move left
        }
        return -1;
    }

    // --- Helper 3: Flipped Binary Search (Descending) ---
    private int binarySearchDescending(MountainArray arr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = arr.get(mid);

            if (midVal == target)
                return mid;
            else if (midVal > target)
                left = mid + 1; // Target is smaller, but array descends, so move right!
            else
                right = mid - 1; // Target is larger, but array descends, so move left!
        }
        return -1;
    }
}