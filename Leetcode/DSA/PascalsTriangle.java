import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    //New Solution - Striver
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        for(int row=1; row<=numRows; row++){
            Integer ele = 1;
            List<Integer> ansRow = new ArrayList<>();
            ansRow.add(1);
            for(int col=1; col<row; col++){
                ele *= (row-col);
                ele /= col;
                ansRow.add(ele);
            }
            answer.add(ansRow);
        }
        return answer;
    }

    //Old Solution
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (numRows <= 0) {
            return triangle;
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }
            }
            triangle.add(row);
        }
        return triangle;
    }
}
