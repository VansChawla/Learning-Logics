import javax.swing.tree.TreeNode;

public class DiameterofBinaryTree {

    int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    public int height(TreeNode root) {
        if (root == null)
            return 0;
        int leftD = height(root.left);
        int rightD = height(root.right);
        diameter = Math.max(diameter, leftD + rightD);

        return 1 + Math.max(leftD, rightD);
    }
}