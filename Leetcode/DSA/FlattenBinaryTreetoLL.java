class FlattenBinaryTreetoLL {
    public void flatten(TreeNode root) {
        if(root == null) return;

        TreeNode current = root;
        while(current != null) {
            if(current.left != null){
                TreeNode rightMost = current.left;
                while(rightMost.right != null){
                    rightMost = rightMost.right;
                }
                rightMost.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }
}