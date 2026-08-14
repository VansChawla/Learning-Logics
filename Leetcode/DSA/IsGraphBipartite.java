import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
    //New Solution with DFS and BFS
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] vis = new int[n];
        Arrays.fill(vis, -1);

        for(int i=0; i<n; i++){
            if(vis[i] == -1){
                // if(!bfs(graph, vis, i))
                if(!dfs(graph, vis, i, -1, 0))
                    return false;
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int[] vis, int curr, int par, int color){
        vis[curr] = color;
        for (int neighbor : graph[curr]) {
            if(neighbor == par)
                continue;

            if(vis[neighbor] == -1){
                if(!dfs(graph, vis, neighbor, curr, 1-color))
                    return false;
            }
            else if(vis[neighbor] == vis[curr]){
                return false;
            }
        }
        return true;
    }

    private boolean bfs(int[][] graph, int[] vis, int i){
        vis[i] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);

        while(!q.isEmpty()){
            int front = q.remove();
            int color = vis[front];
            for (int neighbor : graph[front]) {
                if(vis[neighbor] == -1){
                    vis[neighbor] = 1-color;
                    q.add(neighbor);
                }
                else if(vis[neighbor] == vis[front]){
                    return false;
                }
            }
        }
        return true;
    }


    //Old Solution with BFS
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
