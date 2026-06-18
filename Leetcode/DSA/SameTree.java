class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case: both null, or one null/mismatch
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        
        // Recursive check for subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}