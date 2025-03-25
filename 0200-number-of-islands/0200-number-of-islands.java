class Solution {
    private void bfs(int ro,int co,char[][] grid,boolean[][] vis){
        vis[ro][co] = true;
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        q.add(new Pair<>(ro,co));
        // Movement in 4 directions: Up, Down, Left, Right
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int row = q.peek().getKey();
            int col = q.peek().getValue();
            q.remove();

            for (int i = 0; i < 4; i++) { // Only move in 4 directions
                int nrow = row + dx[i];
                int ncol = col + dy[i];

                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n &&
                    grid[nrow][ncol] == '1' && !vis[nrow][ncol]) {
                    vis[nrow][ncol] = true;
                    q.add(new Pair<>(nrow, ncol));
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(vis[i][j] == false && grid[i][j] == '1'){
                    bfs(i,j, grid, vis);
                    count++;
                }
            }
        }




        return count;
    }
}