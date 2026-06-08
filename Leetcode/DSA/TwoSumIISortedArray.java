class TwoSumIISortedArray {
    public int[] twoSum(int[] numbers, int target) {
        //OPTIMIZED - Two Pointer Approach
        int left = 0; 
        int right = numbers.length-1;

        while(left < right){
            int total = numbers[left] + numbers[right];

            if(total > target)
                right--;
            else if(total < target)
                left++;
            else
                return new int[]{left+1, right+1};

        } 

        return new int[]{-1,-1};
    }
}


//BRUTEFORCE APPROACH -O(N^2)

// int[] result = new int[2];    
// for(int i=0; i<numbers.length-1; i++){
//     for(int j=i+1; j<numbers.length; j++){
//         if(numbers[i] + numbers[j] == target){
//             result[0] = i+1;
//             result[1] = j+1;
//         }
//     }
// }
// return result;