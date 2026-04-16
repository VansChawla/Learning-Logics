public class MaxXORofTwoNumbersinanArray {
    // 1. Define the Trie Node
    class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }
    
    TrieNode root;
    
    // Helper to insert a number's 32-bit representation into the Trie
    private void insert(int num) {
        TrieNode curr = root;
        // Start from the most significant bit (31st bit)
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            
            // If the branch doesn't exist, create it
            if (curr.children[bit] == null) {
                curr.children[bit] = new TrieNode();
            }
            // Move down the branch
            curr = curr.children[bit];
        }
    }
    
    // Helper to find the maximum XOR for a specific number
    private int getMaxXor(int num) {
        TrieNode curr = root;
        int maxXor = 0;
        
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int oppositeBit = 1 - bit; // This is the bit we WANT to find to maximize XOR
            
            // If the opposite bit exists in the Trie, take that path!
            if (curr.children[oppositeBit] != null) {
                // Shift a 1 into the current position of our result
                maxXor |= (1 << i);
                curr = curr.children[oppositeBit];
            } else {
                // We are forced to take the matching bit path (contributes 0 to XOR)
                curr = curr.children[bit];
            }
        }
        return maxXor;
    }

    public int findMaximumXOR(int[] nums) {
        // Edge case: If there's only 1 element, it XORs with itself to become 0
        if (nums == null || nums.length <= 1) return 0;
        
        root = new TrieNode();
        
        // Step 1: Insert all numbers into the Trie
        for (int num : nums) {
            insert(num);
        }
        
        int maxResult = 0;
        
        // Step 2: For every number, find its best possible XOR partner in the Trie
        for (int num : nums) {
            maxResult = Math.max(maxResult, getMaxXor(num));
        }
        
        return maxResult;
    }
}
