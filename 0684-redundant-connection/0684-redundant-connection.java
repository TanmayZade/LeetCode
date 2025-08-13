import java.util.*;

class Solution {
    static class DisjointSet{
        List<Integer> parent = new ArrayList<>();
        List<Integer> rank = new ArrayList<>();
        DisjointSet(int n){
            for(int i = 0;i < n;i++){
                parent.add(i);
                rank.add(0);
            }
        }
        
        public int findParent(int node){
            if(node == parent.get(node)) return node;
            int ult_prnt = findParent(parent.get(node));
            parent.set(node, ult_prnt); //path compression
            return ult_prnt;
        }
        
        public void unionByRank(int u,int v){
            int ultP_u = findParent(u);
            int ultP_v = findParent(v);
            if(ultP_u == ultP_v) return;
            
            if(rank.get(ultP_u) < rank.get(ultP_v))
                parent.set(ultP_u, ultP_v);
            else if(rank.get(ultP_v) < rank.get(ultP_u))
                parent.set(ultP_v, ultP_u);
            else{
                parent.set(ultP_v, ultP_u);
                rank.set(ultP_u, rank.get(ultP_u) + 1);
            }
        }
        
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet dj = new DisjointSet(n+1);

        for(int i = 0;i < n;i++){
            if(dj.findParent(edges[i][0]) == dj.findParent(edges[i][1]))
                return new int[]{edges[i][0], edges[i][1]};
            else
                dj.unionByRank(edges[i][0], edges[i][1]);
        }

        return new int[]{-1,-1};
    }
}