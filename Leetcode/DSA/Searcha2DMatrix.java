public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows*cols-1;
        
        while(left <= right){
            int mid = (left + (right - left) / 2);
            int midVal = matrix[mid / cols][mid % cols];

            if(midVal == target){
                return true;
            } else if(midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
