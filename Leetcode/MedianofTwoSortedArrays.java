public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array = mergeSorted(nums1, nums2);
        int n = array.length;
        double result = 0.0;

        if (n % 2 == 0) {
            result = (double) (array[n / 2] + array[(n / 2) - 1]) / 2;
        } else {
            result = (double) array[n / 2];
        }

        return result;
    }

    public static int[] mergeSorted(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] merged = new int[n1 + n2];
        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }
        while (i < n1) {
            merged[k++] = arr1[i++];
        }
        while (j < n2) {
            merged[k++] = arr2[j++];
        }
        return merged;
    }
}
