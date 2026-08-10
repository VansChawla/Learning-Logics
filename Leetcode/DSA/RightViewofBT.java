import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

class RightViewofBT {

    // Recursive approach
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

    // Iterative approach
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
           if(root == null) return ans;
           
           Queue<TreeNode> q = new LinkedList<>();
           q.add(root);
           
           while(!q.isEmpty()){
               ans.add(q.peek().val);
               int n = q.size();
               
               while(n != 0){
                   TreeNode temp = q.poll();
                        
                   if(temp.right != null)
                        q.add(temp.right);

                    if(temp.left != null)
                        q.add(temp.left);
                        
                    n--;
               }
           }
           
        return ans;
    }
}
