class NetworkDelayTime {
    // BellmanFord algorithm
    public int networkDelayTime(int[][] times, int n, int src) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for(int x=1; x<=n-1; x++){  //n-1 times edges travel
            for(int i=0; i<times.length; i++){   //all edges relax
                int u = times[i][0];
                int v = times[i][1];
                int wt = times[i][2];
                if(dist[u] != Integer.MAX_VALUE && dist[u]+wt < dist[v])
                    dist[v] = dist[u] + wt;
            }
        }

        //nth time relaxation for -ve cycle detection
        for(int i=0; i<times.length; i++){   //all edges relax
            int u = times[i][0];
            int v = times[i][1];
            int wt = times[i][2];
            if(dist[u] != Integer.MAX_VALUE && dist[u]+wt < dist[v])
                return -1;
        }

        int max = -1;
        for(int i=1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        
        return max;
    }

    // Dijkstra algorithm
    public class Pair implements Comparable<Pair>{
        int node;
        int time;
        Pair(int node, int time){
            this.node = node;
            this.time = time;
        }
        @Override
        public int compareTo(Pair p){
            if(this.time == p.time) return this.node - p.node;
            return this.time - p.time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<Pair>());
        for(int i=0; i<times.length; i++){
            int u = times[i][0], v = times[i][1], time = times[i][2];
            adj.get(u).add(new Pair(v, time));
        }

        int[] ans = new int[n+1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[k] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(); //<>((a, b) -> a.time - b.time)
        pq.add(new Pair(k,0));
        while(pq.size()>0){
            Pair top = pq.remove();
            int node = top.node, time = top.time;
            if(top.time > ans[node]) continue;
            for(Pair p : adj.get(node)){
                int totalTime = top.time + p.time;
                if(totalTime < ans[p.node]){
                    ans[p.node] = totalTime;
                    pq.add(new Pair(p.node,totalTime));
                }
            }
        }

        int max = -1;
        for(int i=1; i<=n; i++){
            if(ans[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, ans[i]);
        }
        
        return max;
    }
}