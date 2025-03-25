class Solution {
        private static void bfs(boolean vis[],ArrayList<ArrayList<Integer>> ls,Integer node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;
        while(!q.isEmpty()){
            Integer val = q.poll();
            vis[val] = true;
            for(Integer it : ls.get(val)){
                if(vis[it] == false ){
                    q.add(it);
                    vis[it] = true;
                }
            }
        }
    }
    public int findCircleNum(int[][] adj) {
        int V = adj.length;
        boolean vis[] = new boolean[V];
        int count = 0;
        //convert matrix to list
        ArrayList<ArrayList<Integer>> ls = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i < V;i++)
            ls.add(new ArrayList<Integer>());
        for(int i = 0;i < V;i++){
            for(int j = 0;j < V;j++){
                if(adj[i][j] == 1 && i != j){
                    ls.get(i).add(j) ;
                    ls.get(j).add(i);
                }
            }
        }
        
        //traversing vis array to find no. of provinces
        for(int i = 0;i < V;i++){
            if(vis[i] == false){
                bfs(vis, ls, i);
                count++;
            }
        }
        
        
        
        
        return count;
    }
    
}