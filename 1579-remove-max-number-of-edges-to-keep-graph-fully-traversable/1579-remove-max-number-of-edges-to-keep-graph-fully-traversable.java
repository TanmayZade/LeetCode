class Solution {
    class UnionFind {
        private int[] parent, rank;
        private int count; // Number of connected components
        
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int u) {
            if (u != parent[u]) {
                parent[u] = find(parent[u]);
            }
            return parent[u];
        }
        
        public boolean union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);
            
            if (rootU != rootV) {
                if (rank[rootU] > rank[rootV]) {
                    parent[rootV] = rootU;
                } else if (rank[rootU] < rank[rootV]) {
                    parent[rootU] = rootV;
                } else {
                    parent[rootV] = rootU;
                    rank[rootU]++;
                }
                count--;
                return true;
            }
            return false;
        }
        
        public int getCount() {
            return count;
        }
    }
    
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind ufAlice = new UnionFind(n);
        UnionFind ufBob = new UnionFind(n);
        UnionFind ufCommon = new UnionFind(n);
        
        int removableEdges = 0;
        
        // Process type 3 edges first
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                boolean aliceMerged = ufAlice.union(edge[1] - 1, edge[2] - 1);
                boolean bobMerged = ufBob.union(edge[1] - 1, edge[2] - 1);
                if (!aliceMerged && !bobMerged) {
                    removableEdges++;
                }
            }
        }
        
        // Process type 1 edges for Alice
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (!ufAlice.union(edge[1] - 1, edge[2] - 1)) {
                    removableEdges++;
                }
            }
        }
        
        // Process type 2 edges for Bob
        for (int[] edge : edges) {
            if (edge[0] == 2) {
                if (!ufBob.union(edge[1] - 1, edge[2] - 1)) {
                    removableEdges++;
                }
            }
        }
        
        // Check if both graphs are fully traversable
        if (ufAlice.getCount() != 1 || ufBob.getCount() != 1) {
            return -1;
        }
        
        return removableEdges;
    }
}
