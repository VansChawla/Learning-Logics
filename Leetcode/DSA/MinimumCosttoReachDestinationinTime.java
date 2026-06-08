import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumCosttoReachDestinationinTime {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;

        // 1. Build an Adjacency List for the graph
        // graph.get(i) contains a list of int[]{neighbor, travelTime}
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[] { edge[1], edge[2] });
            graph.get(edge[1]).add(new int[] { edge[0], edge[2] });
        }

        // 2. Array to track the absolute fastest time we've ever reached a city
        int[] minTime = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);

        // 3. Min-Heap Priority Queue ordered primarily by minimum COST
        // Storing arrays: [currentCost, currentTime, currentCity]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Start at city 0, minute 0, paying the fee for city 0
        pq.offer(new int[] { passingFees[0], 0, 0 });

        // 4. Run Modified Dijkstra
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int time = curr[1];
            int city = curr[2];

            // If this path already exceeds our time limit, it's invalid
            if (time > maxTime)
                continue;

            // Because the PQ is strictly ordered by cost, the VERY FIRST TIME
            // we pop the destination city, it is mathematically guaranteed to be the
            // minimum cost!
            if (city == n - 1) {
                return cost;
            }

            // PRUNING: If we've been to this city before, and it took LESS or EQUAL time,
            // this current path is worse (because it costs more and is slower). Skip it.
            if (time >= minTime[city]) {
                continue;
            }
            // Otherwise, record this new fastest time
            minTime[city] = time;

            // Explore all neighbors
            for (int[] neighbor : graph.get(city)) {
                int nextCity = neighbor[0];
                int travelTime = neighbor[1];

                // Only push to the queue if it doesn't exceed maxTime
                if (time + travelTime <= maxTime) {
                    pq.offer(new int[] {
                            cost + passingFees[nextCity],
                            time + travelTime,
                            nextCity
                    });
                }
            }
        }

        // If the queue empties and we never returned inside the loop, it's impossible
        return -1;
    }
}
