public class FindKthBitinNthBinaryString {
    public char findKthBit(int n, int k) {
        // Base case: For S1, there is only one character, which is '0'.
        if (n == 1) {
            return '0';
        }

        // Calculate the length of Sn, which is 2^n - 1.
        // We use bit shifting (1 << n) to quickly calculate 2^n.
        int length = (1 << n) - 1;

        // The middle element's 1-based index
        int mid = length / 2 + 1;

        // Case 1: k is exactly the middle element
        if (k == mid) {
            return '1';
        }

        // Case 2: k is in the left half
        if (k < mid) {
            return findKthBit(n - 1, k);
        }

        // Case 3: k is in the right half
        // Find the mirrored position in the left half, recurse, and invert the result.
        char mirroredBit = findKthBit(n - 1, length - k + 1);
        return mirroredBit == '0' ? '1' : '0';
    }
}
