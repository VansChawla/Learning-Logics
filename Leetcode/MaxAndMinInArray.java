import java.util.ArrayList;

public class MaxAndMinInArray {
    public ArrayList<Integer> getMinMax(int[] arr) {
        int setMin = Integer.MAX_VALUE;
        int setMax = Integer.MIN_VALUE;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]<setMin){
                setMin = arr[i];
            }
            if(arr[i]>setMax){
                setMax = arr[i];
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(setMin);
        result.add(setMax);
        
        return result;
    }
}
