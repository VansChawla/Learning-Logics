class KeysNRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        bfs(0, vis, rooms);

        boolean ans = false;
        for(int i=0; i<n; i++){
            if(!vis[i])
                return false;
        }
        return true;
    }

    private void bfs(int i, boolean[] vis, List<List<Integer>> rooms){
        Queue<Integer> q = new LinkedList<>();

        vis[i] = true;
        q.add(i);

        while(q.size()>0){
            int front = q.remove();
            for(int key : rooms.get(front)){
                if(!vis[key]){
                    vis[key] = true;
                    q.add(key);
                }
            }
        }
    }
}