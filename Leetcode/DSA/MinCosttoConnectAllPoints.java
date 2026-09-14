public class MinCosttoConnectAllPoints {
    
    // Kruskal's Algorithm
    static int[] parent;
    static int[] size;
    public int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    public void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            if(size[a] > size[b]){
                parent[b] = a;
                size[a] += size[b];
            } else {
                parent[a] = b;
                size[b] += size[a];
            }
        }
    }

    class Edge implements Comparable<Edge>{
        int u;
        int v;
        int dist;
        public Edge(int u, int v, int dist){
            this.u = u;
            this.v = v;
            this.dist = dist;
        }
        @Override
        public int compareTo(Edge e){
            if(this.dist == e.dist) return this.u - e.u;
            return this.dist - e.dist;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        List<Edge> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                int dist = Math.abs(x1-x2) + Math.abs(y1-y2);
                list.add(new Edge(i, j, dist));
            }
        }
        Collections.sort(list);
        int cost = 0;
        for(int i=0; i<list.size(); i++){
            Edge top = list.get(i);
            int u = top.u, v = top.v, dist = top.dist;
            if(find(u) != find(v)){
                cost += dist;
                union(u, v);
            }
        }

        return cost;
    }

    // Prim's Algorithm
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
