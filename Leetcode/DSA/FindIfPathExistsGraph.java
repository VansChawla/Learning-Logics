import java.util.ArrayList;
import java.util.List;

public class FindIfPathExistsGraph {
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
