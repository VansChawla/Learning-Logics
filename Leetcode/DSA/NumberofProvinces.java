import java.util.LinkedList;
import java.util.Queue;

class NumberofProvinces {
    // DSU (Disjoint Set Union)
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

    public int findCircleNum(int[][] adj) {
       int n = adj.length;
        parent = new int[n+1];
        size = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
            size[i] = i;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i!=j && adj[i][j]==1) union(i+1, j+1); //connecting group leaders of i+1 & j+1
            }
        }

        int count = 0;
        for(int i=1; i<=n ;i++){
            if(parent[i] == i) count++;
        }

        return count;
    }
    

    //DFS/BFS
    public int findCircleNum(int[][] adj) {
        int n = adj.length;
        int count = 0;
        boolean[] vis = new boolean[n];
        for(int i=0; i<n; i++){
            if(!vis[i]){
                // bfs(i, adj, vis);
                dfs(i, adj, vis);
                count++;
            }
        }
        return count;
    }

    //DFS
    private void dfs(int i, int[][] adj, boolean[] vis){
        int n = adj.length;
        vis[i] = true;
        for(int j=0; j<n; j++){
            if(adj[i][j] == 1 && !vis[j]){
                dfs(j, adj, vis);
            }
        }
    }

    //BFS
    private void bfs(int i, int[][] adj, boolean[] vis){
        int n = adj.length;
        vis[i] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(q.size()>0){
            int front = q.remove();
            for(int j=0; j<n; j++){
                if(adj[front][j] == 1 && vis[j] == false){
                    q.add(j);
                    vis[j] = true;
                }
            }
        }
    }
}