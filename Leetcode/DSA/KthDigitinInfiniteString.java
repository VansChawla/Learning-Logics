class KthDigitinInfiniteString {
    public int kthDigit(long k) {
        // Step 1: Block b = 0 handles digits for numbers 0-9 (10 digits total)
        if (k < 10) {
            return (int) k;
        }

        k -= 10; // Skip block b = 0

        // Step 2: Group by digit count (d = 2, 3, 4...)
        long d = 2;
        long countBlocks = 9; // Total blocks in current digit group
        long startB = 1;      // First block index for current digit group

        while (true) {
            long digitsPerBlock = 10 * d;
            long totalDigitsInGroup = countBlocks * digitsPerBlock;

            if (k < totalDigitsInGroup) {
                break; // Target digit is within this group
            }

            k -= totalDigitsInGroup;
            d++;
            countBlocks *= 10;
            startB *= 10;
        }

        // Step 3: Find exact block 'b'
        long digitsPerBlock = 10 * d;
        long blockOffset = k / digitsPerBlock;
        long remainingK = k % digitsPerBlock;

        long b = startB + blockOffset;

        // Step 4: Find the specific number inside block 'b'
        long numIndex = remainingK / d;
        long digitOffset = remainingK % d;

        long targetNum;
        if (b % 2 == 0) {
            // Even block: 10*b + 0, 10*b + 1, ..., 10*b + 9
            targetNum = 10 * b + numIndex;
        } else {
            // Odd block: 10*b + 9, 10*b + 8, ..., 10*b + 0
            targetNum = 10 * b + (9 - numIndex);
        }

        // Step 5: Extract target digit from the number
        String numStr = String.valueOf(targetNum);
        return numStr.charAt((int) digitOffset) - '0';
    }
}