import java.util.ArrayList;
import java.util.List;

public class FindIfPathExistsGraph {

    // BFS approach
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            int a = edges[i][0], b = edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        boolean[] vis = new boolean[n];
        bfs(source, vis, adj);

        return vis[destination];
    }

    private void bfs(int source, boolean[] vis, List<List<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        vis[source] = true;
        q.add(source);

        while(q.size()>0){
            int front = q.remove();
            for(int key : adj.get(front)){
                if(!vis[key]){
                    vis[key] = true;
                    q.add(key);
                }
            }
        }
    }

    // DFS approach
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean vis[] = new boolean[n];

        return dfs(graph, vis, source, destination);
    }

    private boolean dfs(List<List<Integer>> graph, boolean[] vis, int current, int destination) {
        if (current == destination)
            return true;
        vis[current] = true;
        for (int neighbor : graph.get(current)) {
            if (!vis[neighbor] && dfs(graph, vis, neighbor, destination)) {
                return true;
            }
        }
        return false;
    }

}
