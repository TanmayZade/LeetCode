class Solution {
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

    private boolean isValidCell(int[][] grid, int row, int col){
        return row >= 0 && col >= 0 && row < grid.length && col < grid.length && grid[row][col] == 1;
    }
    // public int getSizeOfIsland(int[][] grid, int row, int col){
    //     int n = grid.length;

    //     DisjointSet dj = new DisjointSet(n*n);

    //     //transformation operation
    //     grid[row][col] = 1;
    //     HashMap<Integer, Integer> islandSizes = new HashMap<>();

    //     int dx[] = {-1,1,0,0};
    //     int dy[] = {0,0,1,-1};
    //     int maxSize = 0;
    //     for(int i = 0;i < n;i++){
    //         for(int j = 0;j < n;j++){
    //             if(grid[i][j] == 1){
    //             int node = i * n + j;
    //                 for(int k = 0;k < 4;k++){
    //                     int adjRow = i + dx[k];
    //                     int adjCol = j + dy[k];

    //                     int adjNode = adjRow * n + adjCol;

    //                     if(isValidCell(grid,adjRow,adjCol)){
    //                         dj.unionBySize(adjNode, node);
    //                     }
    //                 }
    //             }
    //         }
    //     }
        
    //     for(int i= 0;i < dj.size.size();i++)
    //             maxSize = Math.max(maxSize, dj.size.get(i));

    //     return maxSize;
    // }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int maxSize = 0;

        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,1,-1};
        //DSJ creation
        DisjointSet dj = new DisjointSet(n*n);

        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == 1){
                int node = i * n + j;
                    for(int k = 0;k < 4;k++){
                        int adjRow = i + dx[k];
                        int adjCol = j + dy[k];

                        int adjNode = adjRow * n + adjCol;

                        if(isValidCell(grid,adjRow,adjCol)){
                            dj.unionBySize(adjNode, node);
                        }
                    }
                }
            }
        }

        //we will replace every 0 with 1
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == 0){
                    HashSet<Integer> parents = new HashSet<>();
                    int node = i * n + j;
                    int currSize = 1;
                    for(int k = 0;k < 4;k++){
                        int adjRow = i + dx[k];
                        int adjCol = j + dy[k];

                        int adjNode = adjRow * n + adjCol;

                        if(isValidCell(grid,adjRow,adjCol) && parents.add(dj.findParent(adjNode)) ){
                            currSize += dj.size.get(dj.findParent(adjNode));
                        }
                    }
                    maxSize = Math.max(currSize, maxSize);
                }
            }
        }
        return maxSize == 0 ? n*n : maxSize;
    }
}