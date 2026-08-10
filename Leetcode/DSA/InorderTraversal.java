import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class InorderTraversal {
    //Morris Traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left == null){ //1st Case
                inorder.add(curr.val);
                curr = curr.right;
            }
            else {
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr){ //Find rightmost node in the left tree
                    prev = prev.right;
                }

                if(prev.right == null){ //2nd Case
                    prev.right = curr; //Thread connected, In left tree, rightmost node -> root
                    curr = curr.left;
                }
                else {                  //3rd Case
                    prev.right = null; //Thread disconnected
                    inorder.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return inorder;
    }

    //Recursive Approach
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }
}
