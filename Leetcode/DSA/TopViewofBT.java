import java.util.*;

class TopViewofBT {
    private int minL = 0;
    private int maxR = 0;

    public ArrayList<Integer> topView(Node root) {
        if (root == null) return new ArrayList<>();
        
        find(root, 0);
        
        int width = maxR - minL + 1;
        
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(width, 0));
        ArrayList<Integer> levelTrack = new ArrayList<>(Collections.nCopies(width, Integer.MAX_VALUE));
        
        topViewRec(root, -1 * minL, ans, levelTrack, 0);
        return ans;
    }
    
    private void find(Node root, int pos) {
        if (root == null) return;
        
        minL = Math.min(pos, minL);
        maxR = Math.max(pos, maxR);
        
        find(root.left, pos - 1);
        find(root.right, pos + 1);
    }
    
    private void topViewRec(Node root, int pos, ArrayList<Integer> ans, ArrayList<Integer> levelTrack, int depth) {
        if (root == null) return;
        
        if (levelTrack.get(pos) > depth) {
            ans.set(pos, root.data);
            levelTrack.set(pos, depth);
        }
        
        topViewRec(root.left, pos - 1, ans, levelTrack, depth + 1);
        topViewRec(root.right, pos + 1, ans, levelTrack, depth + 1);
    }
}