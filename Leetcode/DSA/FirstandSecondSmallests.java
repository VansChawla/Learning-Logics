import java.util.ArrayList;

public class FirstandSecondSmallests {
    public ArrayList<Integer> minAnd2ndMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        int s_min = Integer.MAX_VALUE;
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] < min){
                s_min = min;
                min = arr[i];
            } else if(arr[i] < s_min && arr[i] != min){
                s_min = arr[i];
            }
        }
        
        if(s_min == Integer.MAX_VALUE){
            result.add(-1);
        } else {
            result.add(min);
            result.add(s_min);
        }
        
        return result;
    }
}