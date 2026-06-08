import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourcetoTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();

        currentPath.add(0);
        dfs(graph, 0, currentPath, result);

        return result;
    }

    private void dfs(int[][] graph, int curr, List<Integer> currentPath, List<List<Integer>> result) {
        if (curr == graph.length - 1) {
            result.add(new ArrayList<>(currentPath));
            return;
        }

        for (int neighbor : graph[curr]) {
            currentPath.add(neighbor);
            dfs(graph, neighbor, currentPath, result);
            currentPath.remove(currentPath.size() - 1);
        }
    }
}
