class Solution {
    private int parent[];
    private int findParent(int x){
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    private void union(int x, int y){
        int px = findParent(x);
        int py = findParent(y);
        if(px != py)
            parent[px] = parent[py];
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parent = new int[n];
        for(int i = 0;i < n;i++) parent[i] = i;
        for(var e : edges) union(e[0],e[1]);

        return findParent(source) == findParent(destination);
    }
}