import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] col = new int[n];

        for (int i = 0; i < n; i++) {
            col[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (col[i] == -1) {                 //BFS
                q.add(i);
                col[i] = 0;

                while (!q.isEmpty()) {
                    int curr = q.remove();

                    for (int neighbor : graph[curr]) {
                        if (col[neighbor] == -1) {              //Case-3
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[neighbor] = nextCol;
                            q.add(neighbor);
                        } else if (col[neighbor] == col[curr]) {    //Case-2
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}