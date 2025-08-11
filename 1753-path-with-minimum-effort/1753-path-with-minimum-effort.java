class Solution {
    class Tuple{
        int diff,row,col;
        public Tuple(int diff, int row, int col){
            this.diff = diff;
            this.row = row;
            this.col = col;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int rows[] = {-1,1,0,0};
        int cols[] = {0,0,1,-1};

        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y) -> x.diff - y.diff);
        int nRow = heights.length;
        int nCol = heights[0].length;

        int[][] dist = new int[nRow][nCol];

        for(int i = 0;i < nRow;i++){
            for(int j = 0;j < nCol;j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = 0;
        pq.add(new Tuple(0,0,0));
        while(pq.size() != 0){
            Tuple it = pq.poll();
            int diff = it.diff;
            int row = it.row;
            int col = it.col;
            if(row == nRow - 1 && col == nCol - 1) return diff;
            for(int i = 0;i < 4;i++){
                int currRow = row + rows[i];
                int currCol = col + cols[i];
                if(currRow >= 0 && currRow < nRow && currCol < nCol && currCol >= 0){
                int newEfforts = Math.max(Math.abs(heights[currRow][currCol] - heights[row][col]), diff);

                if(newEfforts < dist[currRow][currCol]){
                    dist[currRow][currCol] = newEfforts;
                    pq.add(new Tuple(newEfforts, currRow, currCol));
                }
                }

            }

        }

        return 0;
    }
}