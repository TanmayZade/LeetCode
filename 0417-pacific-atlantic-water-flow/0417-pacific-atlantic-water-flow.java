class Solution {
    private int n, m;
    private int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic =new boolean[m][n];

        for(int i = 0;i < n;i++) dfs(0,i,heights, pacific);
        for(int i = 0;i < m;i++) dfs(i, 0, heights, pacific);
        for(int i = 0;i < n;i++) dfs(m-1, i, heights, atlantic);
        for(int i = 0;i < m;i++) dfs(i,n-1, heights, atlantic);

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> al = new ArrayList<>();
                    al.add(i);
                    al.add(j);
                    result.add(al);
                }
            }
        }
        return result;
    }

    private void dfs(int i, int j, int[][] heights, boolean[][] visited){
        if(visited[i][j]) return;
        visited[i][j] = true;
        for(int[] d: directions){
            int x = d[0] + i, y = d[1] + j;

            if(x < 0 || y < 0 || x >= m || y >= n) continue;
            if(heights[x][y] < heights[i][j]) continue;
            dfs(x,y,heights, visited);
        }
    }
}