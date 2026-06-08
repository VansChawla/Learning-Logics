public class XORQueriesofaSubarray {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefix = new int[n];

        // Step 1: Build the prefix XOR array
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] ^ arr[i];
        }

        // Step 2: Answer the queries in O(1) time each
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int L = queries[i][0];
            int R = queries[i][1];

            // If the query starts from the very beginning, just take the prefix
            if (L == 0) {
                result[i] = prefix[R];
            } else {
                // Otherwise, XOR out the overlapping prefix sum we don't want
                result[i] = prefix[R] ^ prefix[L - 1];
            }
        }

        return result;
    }
}
