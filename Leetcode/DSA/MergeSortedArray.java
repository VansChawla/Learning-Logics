import java.util.Arrays;

public class MergeSortedArray {

    // Function to merge the arrays using the Gap Method (Shell Sort variant)
    private void swapIfGreater(int[] nums1, int[] nums2, int ind1, int ind2) {
        if (nums1[ind1] > nums2[ind2]) {
            int temp = nums1[ind1];
            nums1[ind1] = nums2[ind2];
            nums2[ind2] = temp;
        }
    }

    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        int gap = (len / 2) + (len % 2);
        
        while (gap > 0) {
            int left = 0;
            int right = left + gap;
            
            while (right < len) {
                // Case 1: left is in nums1 and right is in nums2
                if (left < m && right >= m) {
                    swapIfGreater(nums1, nums2, left, right - m);
                }
                // Case 2: both left and right are in nums2
                else if (left >= m) {
                    swapIfGreater(nums2, nums2, left - m, right - m);
                } 
                // Case 3: both left and right are in nums1
                else {
                    swapIfGreater(nums1, nums1, left, right);
                }
                left++;
                right++;
            }
            
            if (gap == 1) break;
            gap = (gap / 2) + (gap % 2);
        }

        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
    }

    // Function to merge the arrays using the Two-Pointer Method
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m-1;
        int right = 0;
        while(left >= 0 && right < n){
            if(nums1[left] > nums2[right]){
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
                left--; right++;
            } else {
                break;
            }
        }

        Arrays.sort(nums1, 0, m);
        Arrays.sort(nums2);
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
    }

    // Function to merge the arrays using the Three-Pointer Method
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int midx = m - 1;
        int nidx = n - 1;
        int right = m + n - 1;

        while (nidx >= 0) {
            if (midx >= 0 && nums1[midx] > nums2[nidx]) {
                nums1[right] = nums1[midx];
                midx--;
            } else {
                nums1[right] = nums2[nidx];
                nidx--;
            }
            right--;
        }
    }
}
