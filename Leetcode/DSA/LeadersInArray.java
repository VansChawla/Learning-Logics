import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArray {
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();
        int max = arr[arr.length-1];
        result.add(max);
        
        for(int i=arr.length-2; i>=0; i--){
            if(arr[i] >= max){
                result.add(arr[i]);
                max = arr[i];
            }
        }
        
        Collections.reverse(result);
        return result;
    }
}