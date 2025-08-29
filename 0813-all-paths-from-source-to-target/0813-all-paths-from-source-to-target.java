//approach 
// we will find each path using DFS for all src nghrs until we get null or dest
//if we get dest we will add it in paths
//we will need to take care of vis array

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;

        boolean vis[][] = new boolean[n][n];
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++) adj.add(new ArrayList<>());
        for(int i = 0;i < n;i++){
            for(int j = 0;j < graph[i].length;j++)
            adj.get(i).add(graph[i][j]);
        }
        int src = 0, dest = n-1;
        // path.add(0);
        // for(int i = 0;i < adj.get(0).size();i++)
        //     dfs(adj, paths, path, dest, adj.get(0).get(i));
        dfs(adj, paths, path, dest, src);

        return paths;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, List<List<Integer>> paths, List<Integer> path,int dest, int curr){
        path.add(curr);
        if(curr == dest){
            paths.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        if(adj.get(curr).size() == 0){
            path.remove(path.size() -1);
            return;
        }
        for(int i = 0;i < adj.get(curr).size();i++){
            dfs(adj, paths, path, dest, adj.get(curr).get(i));
        }
        path.remove(path.size() - 1);
    }
}