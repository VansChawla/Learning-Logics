class FindEventualSafeStatesORFindNonCycleNodes {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // Reverse the graph
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>()); 
        int[] indegree = new int[n];
        for(int i=0; i<n; i++){
            for(int ele : graph[i]){
                // In org graph edge is i -> ele
                // In rev graph edge is ele -> i
                adj.get(ele).add(i);
                indegree[i]++;
            }
        }

        // Kahn's Algorithm
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(indegree[i] == 0)
                q.add(i);
        }

        while(q.size()>0){
            int front = q.remove();
            ans.add(front);
            for(int ele : adj.get(front)){
                indegree[ele]--;
                if(indegree[ele] == 0)
                    q.add(ele);
            }
        }

        Collections.sort(ans);
        return ans;
    }
}