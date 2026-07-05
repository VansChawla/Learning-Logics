import java.util.Stack;

/** 
 * Definition for a binary tree node. 
 * public class TreeNode { 
 *     int val; 
 *     TreeNode left; 
 *     TreeNode right; 
 *     TreeNode() {} 
 *     TreeNode(int val) { this.val = val; } 
 *     TreeNode(int val, TreeNode left, TreeNode right) { 
 *         this.val = val; 
 *         this.left = left; 
 *         this.right = right; 
 *     } 
 * } 
 */
class BSTIterator {
    // Stack to simulate the controlled in-order traversal call stack
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        // Push the root and all its left descendants to initialize
        pushLeftChildren(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        // The top of the stack is always the next smallest node
        TreeNode node = stack.pop();
        
        // If the popped node has a right child, process its leftmost branch
        if (node.right != null) {
            pushLeftChildren(node.right);
        }
        
        return node.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        // If the stack contains elements, a next element exists
        return !stack.isEmpty();
    }

    // Helper method to push a node and all its deep-left descendants
    private void pushLeftChildren(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

/** 
 * Your BSTIterator object will be instantiated and called as such: 
 * BSTIterator obj = new BSTIterator(root); 
 * int param_1 = obj.next(); 
 * boolean param_2 = obj.hasNext(); 
 */
