import java.util.*;

public class Solution {

    static class DisjointSet{
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        DisjointSet(int n){
            for(int i = 0;i <= n;i++){
                size.add(1);
                parent.add(i);
            }
        }

        public int findParent(int node){
            if(node == parent.get(node)) return node;

            int ult_parent = findParent(parent.get(node));
            parent.set(node, ult_parent);
            return ult_parent;
        }

        public void unionBySize(int u,int v){
            int ultP_u = findParent(u);
            int ultP_v = findParent(v);
            if(ultP_v == ultP_u) return;

            if(size.get(ultP_u) < size.get(ultP_v)){
                parent.set(ultP_u, ultP_v);
                size.set(ultP_v, size.get(ultP_u) + size.get(ultP_v));
            }else{
                parent.set(ultP_v, ultP_u);               
            size.set(ultP_u, size.get(ultP_u) + size.get(ultP_v));
            }
        }
    }

    class Edge{
        int dest;
        int src;
        Edge(int dest, int src){
            this.dest = dest;
            this.src = src;
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<Edge> edges = new ArrayList<>();


        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(isConnected[i][j] == 1){
                    edges.add(new Edge(i,j));
                    // edges.add(new Edge(j,i)); // try to remove this edge as this will be ignored by disjoint
                }
            }
        }

        DisjointSet dj = new DisjointSet(n);
        int E = edges.size();

        for(int i = 0;i < E;i++){
            int src = edges.get(i).src;
            int dest = edges.get(i).dest;

            if(dj.findParent(src) != dj.findParent(dest)){
                dj.unionBySize(src, dest);
            }
        }

        Set<Integer> st = new HashSet<>();

        for(int i = 0;i < n;i++){
            if(!st.contains(dj.findParent(i))) st.add(dj.findParent(i));
        }

        return st.size();
    }
}