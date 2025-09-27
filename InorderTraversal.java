import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        preorder(node.left, result);
        result.add(node.val);
        preorder(node.right, result);
    }
}
