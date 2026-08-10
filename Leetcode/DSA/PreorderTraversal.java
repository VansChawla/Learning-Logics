import java.util.ArrayList;
import java.util.List;

class PreorderTraversal {
    //Morris Traversal
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left == null){ //1st Case
                preorder.add(curr.val);
                curr = curr.right;
            }
            else {
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr){ //Find rightmost node in the left tree
                    prev = prev.right;
                }

                if(prev.right == null){ //2nd Case
                    prev.right = curr; //Thread connected, In left tree, rightmost node -> root
                    preorder.add(curr.val);
                    curr = curr.left;
                }
                else {                  //3rd Case
                    prev.right = null; //Thread disconnected
                    curr = curr.right;
                }
            }
        }
        return preorder;
    }

    //Recursive Approach
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }
    private void preorder(TreeNode node, List<Integer> result){
        if(node==null){
            return;
        }
        result.add(node.val);
        preorder(node.left, result);
        preorder(node.right, result);
    }
}