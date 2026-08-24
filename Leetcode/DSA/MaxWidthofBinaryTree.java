class MaxWidthofBinaryTree {
    class Pair {
        TreeNode node;
        int index;
        
        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxWidth = 0;
        Queue<Pair> queue = new LinkedList<>();
        
        // Root starts at index 0
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            
            // Peek the first element to get the baseline index of this level
            int minIndexAtLevel = queue.peek().index;
            
            int firstIdx = 0;
            int lastIdx = 0;

            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                TreeNode node = current.node;
                
                // CRUCIAL: Subtract the minIndex to normalize indices back to 0.
                // This prevents exponential growth and integer overflow!
                int normalizedIdx = current.index - minIndexAtLevel;

                // Track the boundaries of the current level
                if (i == 0) {
                    firstIdx = normalizedIdx;
                }
                if (i == size - 1) {
                    lastIdx = normalizedIdx;
                }

                // Push children with their 0-indexed formulas: (2 * i + 1) and (2 * i + 2)
                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * normalizedIdx + 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * normalizedIdx + 2));
                }
            }

            // Calculate width for this level and update max
            int currentWidth = lastIdx - firstIdx + 1;
            maxWidth = Math.max(maxWidth, currentWidth);
        }

        return maxWidth;
    }
}