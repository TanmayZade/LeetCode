class Solution {
    static class DisjointSet {
        int[] size;
        int[] parent;

        DisjointSet(int n) {
            size = new int[n + 1];
            parent = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }

        public int findParent(int node) {
            if (node == parent[node]) return node;
            return parent[node] = findParent(parent[node]); // Path compression
        }

        public void unionBySize(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);
            if (pu == pv) return;

            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }

    private boolean isValidCell(int[][] grid, int row, int col) {
        int n = grid.length;
        return row >= 0 && col >= 0 && row < n && col < n && grid[row][col] == 1;
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        DisjointSet dj = new DisjointSet(n * n);

        // Step 1: Build DSU for all 1's
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int node = i * n + j;
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dx[k];
                        int nc = j + dy[k];
                        if (isValidCell(grid, nr, nc)) {
                            int adjNode = nr * n + nc;
                            dj.unionBySize(node, adjNode);
                        }
                    }
                }
            }
        }

        int maxSize = 0;

        // Step 2: Try converting each 0 into 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    HashSet<Integer> parents = new HashSet<>();
                    int currSize = 1; // this cell being flipped

                    for (int k = 0; k < 4; k++) {
                        int nr = i + dx[k];
                        int nc = j + dy[k];

                        if (isValidCell(grid, nr, nc)) {
                            int adjNode = nr * n + nc;
                            int parent = dj.findParent(adjNode);
                            if (parents.add(parent)) {
                                currSize += dj.size[parent];
                            }
                        }
                    }
                    maxSize = Math.max(maxSize, currSize);
                }
            }
        }

        // Step 3: If there was no zero, answer is whole grid
        if (maxSize == 0) return n * n;

        return maxSize;
    }
}
