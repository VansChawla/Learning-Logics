public class PeakIndexinaMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        // Notice we use left < right, not left <= right.
        // We want the loop to break exactly when left and right
        // converge on the single peak element.
        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check the slope
            if (arr[mid] < arr[mid + 1]) {
                // We are ascending. The peak is strictly to the right.
                left = mid + 1;
            } else {
                // We are descending (or at the peak). The peak is at mid or to the left.
                right = mid;
            }
        }

        // When left == right, we have pinned down the peak.
        return left;
    }
}
