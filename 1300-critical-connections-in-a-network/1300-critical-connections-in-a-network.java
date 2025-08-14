class Solution {
    int timer = 0;
    public void dfs(ArrayList<ArrayList<Integer>> adj,int time[],int low[],boolean[] vis,int node,int parent, List<List<Integer>> bridges){
        vis[node] = true;
        int newLow = -1;
        time[node] = low[node] = ++timer;
        for(int it : adj.get(node)){
            if(!vis[it]){
                dfs(adj, time, low, vis, it, node,bridges);
                if(low[node] > low[it]) low[node] = low[it];
                if(low[it] > time[node]) bridges.add(new ArrayList<>(Arrays.asList(node, it)));               

            }
            else if(it != parent && vis[it]){
                low[node] = Math.min(low[node] , time[it]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int time[] = new int[n];
        int low[] =new int[n];
        boolean[] vis = new boolean[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        List<List<Integer>> bridges = new ArrayList<>();

        for(int i = 0;i < n;i++) adj.add(new ArrayList<>());

        for(int i = 0;i < connections.size();i++){
            adj.get(connections.get(i).get(1)).add(connections.get(i).get(0));
            adj.get(connections.get(i).get(0)).add(connections.get(i).get(1));
        }
        dfs(adj, time, low, vis, 0, -1, bridges);

        return bridges;
    }
}