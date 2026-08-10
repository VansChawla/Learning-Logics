import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;

public class LeftViewofBT {
    //With Recursion
    public ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        leftViewRec(root, 0, ans);
        return ans;
    }
    
    private void leftViewRec(Node root, int level, ArrayList<Integer> ans){
        if(root == null) return;
        
        if(level == ans.size()){
            ans.add(root.data);
        }
        
        leftViewRec(root.left, level+1, ans);   
        leftViewRec(root.right, level+1, ans);   
    }

    // Using Queue
    public ArrayList<Integer> leftView(Node root) {
           ArrayList<Integer> ans = new ArrayList<>();
           if(root == null) return ans;
           
           Queue<Node> q = new LinkedList<>();
           q.add(root);
           
           while(!q.isEmpty()){
               ans.add(q.peek().data);
               int n = q.size();
               
               while(n != 0){
                   Node temp = q.poll();
                   
                   if(temp.left != null)
                        q.add(temp.left);
                        
                   if(temp.right != null)
                        q.add(temp.right);
                        
                    n--;
               }
           }
           
        return ans;
    }
}