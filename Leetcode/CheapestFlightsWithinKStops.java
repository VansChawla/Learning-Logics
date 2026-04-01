public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        
        cost[src] = 0;

        // Run Bellman-Ford exactly k + 1 times (k stops == k + 1 flights)
        for (int i = 0; i <= k; i++) {
            
            int[] tempCost = Arrays.copyOf(cost, n);

            for (int[] flight : flights) {
                int u = flight[0];     // From city
                int v = flight[1];     // To city
                int price = flight[2]; // Cost of flight

                if (cost[u] != Integer.MAX_VALUE) {
                    tempCost[v] = Math.min(tempCost[v], cost[u] + price);
                }
            }
            
            cost = tempCost;
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}
