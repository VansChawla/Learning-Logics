class WeightedSumofTree {
    public long weightedSum(int[] parent, int[] nums) {
        int n = parent.length;

        // Build Adjacency List (Children of each node)
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            tree.get(parent[i]).add(i);
        }

        // Iterative BFS to compute depth for each node
        int[] depth = new int[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        depth[0] = 1;
        int height = 1;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int child : tree.get(curr)) {
                depth[child] = depth[curr] + 1;
                height = Math.max(height, depth[child]);
                queue.add(child);
            }
        }

        // Compute final weighted sum
        long totalWeight = 0;
        for (int i = 0; i < n; i++) {
            totalWeight += (long) nums[i] * (height - depth[i] + 1);
        }

        return totalWeight;
    }
}