class CourseSchedule {
    //DFS
    private static boolean ans;
    public void dfs(int i, List<List<Integer>> adj, boolean[] vis, boolean[] path){
        vis[i] = true;
        path[i] = true;
        for(int ele : adj.get(i)){
            if(path[ele] == true){
                ans = false;
                return;
            }
            if(vis[ele] == false) dfs(ele, adj, vis, path);
        }
        path[i] = false;
    }
    public boolean canFinish(int n, int[][] pre) {
        ans = true;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int i=0; i<pre.length; i++){
            int a = pre[i][0], b = pre[i][1];
            adj.get(b).add(a);
        }

        boolean[] vis = new boolean[n];
        boolean[] path = new boolean[n];
        for(int i=0; i<n; i++){
            if(vis[i] == false) dfs(i, adj, vis, path);
        }

        return ans;
    }

    //BFS
    public boolean canFinish(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=1;i<=n;i++) adj.add(new ArrayList<>());

        int[] indegree = new int[n];
        boolean[] visited = new boolean[n];

        for(int i=0;i<pre.length;i++){
            int a = pre[i][0], b = pre[i][1]; // b->a edge
            adj.get(b).add(a);
            indegree[a]++;
        }

        // kahn's algorithm
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
                visited[i] = true;
            }
        }

        while(q.size()>0){
            int front = q.remove();
            ans.add(front);
            for(int ele : adj.get(front)){
                indegree[ele]--;
                if(indegree[ele]==0) q.add(ele);
            }
        }

        return ans.size()==n;
    }
}