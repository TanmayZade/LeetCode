class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        boolean[][] vis = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[2] - b[2]));
        int maxTime = 0;
        pq.offer(new int[]{0,0,grid[0][0]});
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,1,-1};

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int x = curr[0],y = curr[1], ht = curr[2];
            maxTime = Math.max(maxTime, ht);

            if(x == n-1 && y == n-1) return maxTime;

            for(int i = 0;i < 4;i++){
                int newX = x + dx[i], newY = y + dy[i];
                if(newX < n && newY < n && newX >= 0 && newY >= 0 && !vis[newX][newY]){
                    vis[newX][newY] = true;
                    pq.offer(new int[]{newX,newY, grid[newX][newY]});
                }
            }
        }
        return maxTime;

    }
}