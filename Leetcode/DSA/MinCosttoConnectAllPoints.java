public class MinCosttoConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        // Priority Queue stores arrays of [distance_to_point, point_index]
        // Sorted automatically by the smallest distance
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Keep track of which points are already in our Minimum Spanning Tree
        boolean[] visited = new boolean[n];

        int totalCost = 0;
        int connectedCount = 0;

        // Start the algorithm at point 0. It costs 0 to reach itself.
        pq.offer(new int[] { 0, 0 });

        // We only need to run until we've connected all 'n' points
        while (!pq.isEmpty() && connectedCount < n) {
            int[] current = pq.poll();
            int weight = current[0];
            int currNode = current[1];

            // If we've already connected this point, skip it to avoid cycles
            if (visited[currNode]) {
                continue;
            }

            // 1. CHOOSE: Add this point to our tree
            visited[currNode] = true;
            totalCost += weight;
            connectedCount++;

            // 2. EXPLORE: Calculate distances to all unvisited neighbors
            for (int nextNode = 0; nextNode < n; nextNode++) {
                if (!visited[nextNode]) {
                    // Calculate Manhattan distance
                    int dist = Math.abs(points[currNode][0] - points[nextNode][0]) +
                            Math.abs(points[currNode][1] - points[nextNode][1]);

                    // Push this potential new edge into the queue
                    pq.offer(new int[] { dist, nextNode });
                }
            }
        }

        return totalCost;
    }
}
