import java.util.ArrayList;
import java.util.Collections;

public class ChocolateDistProblem {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        int n = arr.size();
        int result = Integer.MAX_VALUE;
        Collections.sort(arr);
        
        if(n==0){
            return 0;
        }
        
        for(int i=0; i<n-m+1; i++){
            int minElement = arr.get(i);
            int maxElement = arr.get(i+m-1);
            result = Math.min(result, maxElement-minElement);
        }
        return result;
    }
}
