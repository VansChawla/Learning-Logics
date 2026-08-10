import java.util.*;

// Definition for a binary tree node provided by LeetCode
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class RightViewofBT {

    // Recursive approach to get the right side view of a binary tree
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }
    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null) return;

        if(currDepth == result.size())
            result.add(curr.val);

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
    }    

    // Iterative approach to get the right side view of a binary tree
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at the current level
            int lastValue = 0; // Store the last node's value of the level
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                lastValue = node.val; // Update lastValue with the current node's value
                
                // Add child nodes to queue for next level processing
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            
            result.add(lastValue); // Add the last node's value of this level
        }
        
        return result;
    }
}
