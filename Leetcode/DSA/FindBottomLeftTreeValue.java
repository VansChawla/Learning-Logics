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
class FindBottomLeftTreeValue {
    //BFS Approach
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode node = null;

        q.offer(root);
        while(!q.isEmpty()){
            node = q.poll();

            if(node.right != null)
                q.offer(node.right);
            if(node.left != null)
                q.offer(node.left);
            
        }

        return node.val;
    }
}