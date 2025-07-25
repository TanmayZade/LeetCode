class Solution {
    class Triplet{
        int dist;
        int x;
        int y;
        Triplet (int dist,int x,int y){
            this.dist = dist;
            this.x = x;
            this.y = y;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(n == 1 && grid[0][0] == 0 )
            return 1;

        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0)
        return -1;

        int dist[][] = new int[n][n];
        for(int i = 0;i < n;i++)
            for(int j = 0;j < n ;j++) dist[i][j] = Integer.MAX_VALUE;
        
        Queue<Triplet> q = new LinkedList<>();
        Triplet t = new Triplet(1,0,0);
        q.add(t);
        int[] dx = {-1,1,0,0,-1,-1,1,1};
        int[] dy = {0,0,1,-1,-1,1,1,-1};

        while(!q.isEmpty()){
            int currDist = q.peek().dist;
            int currX = q.peek().x;
            int currY = q.poll().y;

            for(int i = 0;i < 8;i++){
                int newX = currX + dx[i];
                int newY = currY + dy[i];

                if(newX >= 0 && newY >= 0 && newX < n && newY < n && currDist + 1 < dist[newX][newY] && grid[newX][newY] == 0){
                    dist[newX][newY] = currDist + 1;
                    if(newX == n-1 && newY == n-1)
                        return currDist+1;
                    q.add(new Triplet(currDist + 1,newX, newY));
                }
            }

        }
        return -1;

    }
}