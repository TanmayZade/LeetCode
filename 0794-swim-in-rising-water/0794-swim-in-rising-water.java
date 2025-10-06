import java.util.*;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        // Min-heap based on elevation
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, grid[0][0]});
        visited[0][0] = true;
        
        int maxTime = 0;
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], height = cur[2];
            maxTime = Math.max(maxTime, height);
            
            if (x == n - 1 && y == n - 1) return maxTime;
            
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    pq.offer(new int[]{nx, ny, grid[nx][ny]});
                }
            }
        }
        return maxTime;
    }
}
