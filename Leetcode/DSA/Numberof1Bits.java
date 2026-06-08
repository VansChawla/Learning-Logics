class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
}
// class Solution {
//     public int hammingWeight(int n) {
//         String digits = Integer.toBinaryString(n);
//         int count = 0;
//         for(char digit : digits.toCharArray()){
//             if(digit == '1'){
//                 count++;
//             }
//         }
//         return count;
//     }
// }