class Solution {
    public boolean validPath(int n, int[][] edges, int src, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++) adj.add(new ArrayList<>());
        for(int i = 0; i < edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean vis[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            if(node == destination) return true;
            for(int it : adj.get(node)){
                if(!vis[it]){
                    q.add(it);
                    vis[it] = true;
                }
            }

        }
        return false;
    }
}